package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.dto.*;
import edu.fscj.cen3024c.gamepup.entity.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class GameConverter {
    //Game to GameDTO
    public GameDTO convertToGameDTO(Game game) {
        GameDTO gameDTO = new GameDTO();

        gameDTO.setPublishers(
          convertToPublisherDTOs(game.getPublishers())
        );
        gameDTO.setDevelopers(
          convertToDeveloperDTOs(game.getDevelopers())
        );
        gameDTO.setConsoles(
          convertToConsoleDTOs(game.getConsoles())
        );
        gameDTO.setMaturityRating(
          convertToMaturityRatingDTO(game.getMaturityRating())
        );
        gameDTO.setGameName(game.getGameName());
        gameDTO.setGameDesc(game.getGameDesc());
        gameDTO.setReleaseDate(game.getReleaseDate());
        gameDTO.setGameImage(game.getGameImage());
        //added 04/16/2024 for search by multiplayer/online play
        gameDTO.setNumPlayers(game.getNumPlayers());
        gameDTO.setIsCoOp(game.getIsCoOp());
        gameDTO.setIsOnline(game.getIsOnline());
        //added 04/16/2024 for search by low play time and high rating
        gameDTO.setPlayTime(game.getPlayTime());
        gameDTO.setAvgReviewRating(game.getAvgReviewRating());


        return gameDTO;
    }

    private Set<PublisherDTO> convertToPublisherDTOs(Set<Publisher> publishers){
        Set<PublisherDTO> publisherDTOs = new HashSet<>();

        for(Publisher publisher : publishers){
            PublisherDTO publisherDTO = new PublisherDTO();

            publisherDTO.setPublisherName(publisher.getPublisherName());
            publisherDTO.setPublisherDesc(publisher.getPublisherDesc());

            publisherDTOs.add(publisherDTO);
        }

        return publisherDTOs;
    }

    private Set<DeveloperDTO> convertToDeveloperDTOs(Set<Developer> developers){
        Set<DeveloperDTO> developerDTOs = new HashSet<>();

        for(Developer developer : developers) {
            DeveloperDTO developerDTO = new DeveloperDTO();

            developerDTO.setDeveloperName(developer.getDeveloperName());
            developerDTO.setDeveloperDesc(developer.getDeveloperDesc());

            developerDTOs.add(developerDTO);
        }


        return developerDTOs;
    }

    private Set<ConsoleDTO> convertToConsoleDTOs(Set<Console> consoles){
        Set<ConsoleDTO> consoleDTOs = new HashSet<>();

        for(Console console : consoles){
            ConsoleDTO consoleDTO = new ConsoleDTO();
            consoleDTO.setConsoleName(console.getConsoleName());

            consoleDTOs.add(consoleDTO);
        }


        return consoleDTOs;
    }

    private MaturityRatingDTO convertToMaturityRatingDTO(MaturityRating maturityRating){
        MaturityRatingDTO maturityRatingDTO = new MaturityRatingDTO();

        maturityRatingDTO.setLetter(maturityRating.getLetter());
        maturityRatingDTO.setMinAge(maturityRating.getMinAge());
        maturityRatingDTO.setDesc(maturityRating.getDesc());

        return maturityRatingDTO;
    }

    //GameDTO to Game
    public Game convertToGame(GameDTO gameDTO) {
        Game game = new Game();

        game.setPublishers(
          convertToPublishers(gameDTO.getPublishers())
        );
        game.setDevelopers(
          convertToDevelopers(gameDTO.getDevelopers())
        );
        game.setConsoles(
          convertToConsoles(gameDTO.getConsoles())
        );
        game.setMaturityRating(
          convertToMaturityRating(gameDTO.getMaturityRating())
        );
        game.setGameName(gameDTO.getGameName());
        game.setGameDesc(gameDTO.getGameDesc());
        game.setReleaseDate(gameDTO.getReleaseDate());
        game.setGameImage(gameDTO.getGameImage());
        //added 04/16/2024 for search by multiplayer/online play
        game.setNumPlayers(gameDTO.getNumPlayers());
        game.setIsCoOp(gameDTO.getIsCoOp());
        game.setIsOnline(gameDTO.getIsOnline());
        //added 04/16/2024 for search by low play time and high rating
        game.setPlayTime(gameDTO.getPlayTime());
        game.setAvgReviewRating(gameDTO.getAvgReviewRating());


        return game;
    }

    private Set<Publisher> convertToPublishers(Set<PublisherDTO> publisherDTOs){
        Set<Publisher> publishers = new HashSet<>();

        for(PublisherDTO publisherDTO : publisherDTOs){
            Publisher publisher = new Publisher();

            publisher.setPublisherName(publisherDTO.getPublisherName());
            publisher.setPublisherDesc(publisherDTO.getPublisherDesc());

            publishers.add(publisher);
        }

        return publishers;
    }

    private Set<Developer> convertToDevelopers(Set<DeveloperDTO> developerDTOs){
        Set<Developer> developers = new HashSet<>();

        for(DeveloperDTO developerDTO : developerDTOs) {
            Developer developer = new Developer();

            developer.setDeveloperName(developerDTO.getDeveloperName());
            developer.setDeveloperDesc(developerDTO.getDeveloperDesc());

            developers.add(developer);
        }


        return developers;
    }

    private Set<Console> convertToConsoles(Set<ConsoleDTO> consoleDTOs){
        Set<Console> consoles = new HashSet<>();

        for(ConsoleDTO consoleDTO : consoleDTOs){
            Console console = new Console();
            console.setConsoleName(consoleDTO.getConsoleName());

            consoles.add(console);
        }


        return consoles;
    }

    private MaturityRating convertToMaturityRating(MaturityRatingDTO maturityRatingDTO){
        MaturityRating maturityRating = new MaturityRating();

        maturityRating.setLetter(maturityRatingDTO.getLetter());
        maturityRating.setMinAge(maturityRatingDTO.getMinAge());
        maturityRating.setDesc(maturityRating.getDesc());

        return maturityRating;
    }
}
