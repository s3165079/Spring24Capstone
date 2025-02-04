package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.GameConverter;
import edu.fscj.cen3024c.gamepup.converter.ReviewConverter;
import edu.fscj.cen3024c.gamepup.dto.GameDTO;
import edu.fscj.cen3024c.gamepup.dto.ReviewDTO;
import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.entity.Review;
import edu.fscj.cen3024c.gamepup.entity.User;
import edu.fscj.cen3024c.gamepup.entity.UserGame;
import edu.fscj.cen3024c.gamepup.repository.GameRepository;
import edu.fscj.cen3024c.gamepup.repository.ReviewRepository;
import edu.fscj.cen3024c.gamepup.repository.UserGameRepository;
import edu.fscj.cen3024c.gamepup.repository.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;

import static java.util.stream.Collectors.toList;

@Service
public class UserGameService {

    private final GameService gameService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;
    private final UserGameRepository userGameRepository;
    private final GameConverter gameConverter;
    private final GameRepository gameRepository;

    @Autowired
    public UserGameService(GameService gameService,
                           UserService userService,
                           UserRepository userRepository,
                           ReviewRepository reviewRepository,
                           ReviewConverter reviewConverter,
                           UserGameRepository userGameRepository,
                           GameConverter gameConverter,
                           GameRepository gameRepository) {
        this.gameService = gameService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.reviewConverter = reviewConverter;
        this.userGameRepository = userGameRepository;
        this.gameConverter = gameConverter;
        this.gameRepository = gameRepository;

    }

    public List<Integer> getReviewRatingsDTObyGameId(Integer gameId){
        List<UserGame> userGames = userGameRepository.findByGameId(gameId);
        List<Review> reviews = userGames
                .stream()
                .map(UserGame::getReview)
                .toList();
        return reviews
                .stream()
                .map(Review::getReviewRating)
                .collect(toList());
    }

    public ReviewDTO createReview(ReviewDTO reviewDTO,
                                  String userName,
                                  String gameName)
            throws BadRequestException {
        UserGame userGame = new UserGame();

        if(!userExists(userName))
            throw new BadRequestException("Please create a profile first.");
        if(!gameExists(gameName))
            throw new BadRequestException("Game does not exist.");

        int gameId = gameService.getGameIdByGameName(gameName);
        Game game = gameService.getGameByGameId(gameId);

        Integer userId = userService.getUserIdByUserName(userName);
        User user = userService.getUserByUserId(userId);

        if (userHasLeftReviewForGame(user, game)) {
            throw new BadRequestException("You have already left a review for this game. " +
                    "Please update your review instead.");
        }

        Review review = reviewConverter.convertToReview(reviewDTO);

        var rating = review.getReviewRating();

        if (!isValidRating(rating))
            throw new BadRequestException("Invalid rating. " +
                    "Rating must be an integer between 1-5.");

        double avgRating = calculateAverageRating(game);
        game.setAvgReviewRating(avgRating);

        userGame.setGame(game);
        userGame.setUser(user);
        userGame.setReview(review);

        reviewRepository.save(review);
        userGameRepository.save(userGame);

        return reviewConverter.convertToDTO(review);
    }

    private boolean isValidRating(int rating) {
        int minRating = 1;
        int maxRating = 5;
        if (rating <= maxRating && rating >= minRating)
            return true;
        else {
            return false;
        }
    }

    private boolean userHasLeftReviewForGame(User user, Game game) {
        List<UserGame> userGames = userGameRepository.findByUserAndGame(user, game);
        UserGame userGame = userGames.get(0);

        List<Review> allReviews = reviewRepository.findAll();
        List<UserGame> userGamesWithReviews = allReviews.stream().map(userGameRepository::findByReview).toList();

        if (userGamesWithReviews.contains(userGame)) {
            return true;
        }
        return false;
    }

    public ReviewDTO updateReview(ReviewDTO newReviewDTO,
                                  String userName,
                                  String gameName)
            throws BadRequestException, NullPointerException {

        if(!userExists(userName))
            throw new BadRequestException("Please create a profile first.");
        if(!gameExists(gameName))
            throw new BadRequestException("Game does not exist.");

        Review newReview = reviewConverter.convertToReview(newReviewDTO);
        Integer gameId = gameService.getGameIdByGameName(gameName);
        Game game = gameService.getGameByGameId(gameId);

        Integer userId = userService.getUserIdByUserName(userName);
        User user = userService.getUserByUserId(userId);

        List<UserGame> userGameList =
                userGameRepository.findByUserAndGame(user, game);

        UserGame userGame = userGameList.get(0);
        Review origReview = userGame.getReview();

        if (!userHasLeftReviewForGame(user, game)) {
            throw new NullPointerException(
                    "You have not left a review for this game. " +
                    "Please create your review instead.");
        }

        var newRating = newReview.getReviewRating();

        if (!isValidRating(newRating))
            throw new BadRequestException("Invalid rating. " +
                    "Rating must be an integer between 1-5.");

        origReview.setReviewDate(LocalDate.now());
        origReview.setReviewRating(newRating);
        origReview.setReviewContent(newReview.getReviewContent());
        reviewRepository.save(origReview);

        double avgRating = calculateAverageRating(game);
        game.setAvgReviewRating(avgRating);
        gameRepository.save(game);

        return reviewConverter.convertToDTO(origReview);
    }

    public double calculateAverageRating(Game game) {
        List<UserGame> userGames = userGameRepository.findByGame(game);
        List<Review> reviews = userGames
                .stream()
                .map(UserGame::getReview)
                .filter(Objects::nonNull)
                .toList();
        List<Integer> ratings = reviews
                .stream()
                .map(Review::getReviewRating)
                .toList();
        OptionalDouble optionalAverage = ratings.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
        double average = optionalAverage.orElse(0.0);

        DecimalFormat df = new DecimalFormat("#.##");
        String formattedValue = df.format(average);

        return Double.parseDouble(formattedValue);
    }

    public List<String> addGameToUser(String userName,
                                 String gameName)
            throws BadRequestException{

        UserGame userGame = new UserGame();

        if(!userExists(userName))
            throw new BadRequestException("Please create a profile first.");
        if(!gameExists(gameName))
            throw new BadRequestException("Game does not exist.");

        Integer gameId = gameService.getGameIdByGameName(gameName);
        Game game = gameService.getGameByGameId(gameId);

        Integer userId = userService.getUserIdByUserName(userName);
        User user = userService.getUserByUserId(userId);

        if (userHasGameAlready(userName, gameName))
            throw new BadRequestException(
                    "This game is already in your collection");

        userGame.setUser(user);
        userGame.setGame(game);
        userGameRepository.save(userGame);

        List<GameDTO> gameDTOs = findGamesByUserName(userName);
        List<Game> games = gameDTOs
                .stream()
                .map(gameConverter::convertToGame)
                .toList();

        return games.stream().map(Game::getGameName).toList();
    }

    public List<String> removeGameFromUser(String userName,
                                 String gameName)
            throws BadRequestException{
        if(!userExists(userName))
            throw new BadRequestException("Please create a profile first.");
        if(!gameExists(gameName))
            throw new BadRequestException("Game does not exist.");

        Integer gameId = gameService.getGameIdByGameName(gameName);
        Game game = gameService.getGameByGameId(gameId);

        Integer userId = userService.getUserIdByUserName(userName);
        User user = userService.getUserByUserId(userId);

        if (!userHasGameAlready(userName, gameName))
            throw new BadRequestException(
                    "This game is not in your collection");

        List<UserGame> userGames = userGameRepository.findByUserAndGame(user, game);
        UserGame userGame = userGames.get(0);
        userGameRepository.delete(userGame);

        List<GameDTO> gameDTOs = findGamesByUserName(userName);
        List<Game> games = gameDTOs
                .stream()
                .map(gameConverter::convertToGame)
                .toList();

        return games.stream().map(Game::getGameName).toList();
    }



    public boolean userHasGameAlready(String userName, String gameName)
            throws BadRequestException {
        List<GameDTO> gameDTOs = findGamesByUserName(userName);
        List<String> gameNames = gameDTOs.stream().map(GameDTO::getGameName).toList();
        return gameNames.contains(gameName);
    }

    public List<GameDTO> findGamesByUserName(String userName)
            throws BadRequestException{
        if (!userExists(userName))
            throw new BadRequestException("Please create a profile first.");

        Integer userId = userService.getUserIdByUserName(userName);
        List<UserGame> userGames = userGameRepository.findByUserId(userId);
        List<Game> games = userGames
                .stream()
                .map(UserGame::getGame)
                .toList();
        return   games.stream().map(gameConverter::convertToGameDTO).toList();
    }

    public boolean userExists(String userName) {
        List<User> allUsers = userRepository.findAll();
        List<String> allUserNames = allUsers
                .stream()
                .map(User::getUserName)
                .toList();
        return allUserNames.contains(userName);
    }

    public boolean gameExists(String gameName) {
        List<Game> allGames = gameRepository.findAll();
        List<String> allGameNames = allGames
                .stream()
                .map(Game::getGameName)
                .toList();
        return allGameNames.contains(gameName);
    }
}
