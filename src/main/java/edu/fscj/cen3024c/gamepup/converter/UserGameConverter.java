package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.dto.UserGameDTO;
import edu.fscj.cen3024c.gamepup.entity.UserGame;
import org.springframework.stereotype.Component;

@Component
public class UserGameConverter {
    public UserGameDTO convertToDTO(UserGame usergame) {
        UserGameDTO dto = new UserGameDTO();

        dto.setGame(usergame.getGame());
        dto.setUser(usergame.getUser());
        dto.setReview(usergame.getReview());

        return dto;
    }

    // DTO to User
    public UserGame convertToUserGame(UserGameDTO dto) {
        UserGame userGame = new UserGame();

        userGame.setGame(dto.getGame());
        userGame.setUser(dto.getUser());
        userGame.setReview(dto.getReview());

        return userGame;
    }
}
