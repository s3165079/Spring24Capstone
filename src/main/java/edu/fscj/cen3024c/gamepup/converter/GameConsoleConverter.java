package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.dto.GameConsoleDTO;
import edu.fscj.cen3024c.gamepup.entity.GameConsole;
import org.springframework.stereotype.Component;

@Component
public class GameConsoleConverter {

    public GameConsoleDTO convertToGameConsoleDTO(GameConsole gameConsole){
        GameConsoleDTO gameConsoleDTO = new GameConsoleDTO();
        gameConsoleDTO.setGamePrice(gameConsole.getGamePrice());

        return gameConsoleDTO;
    }

    public GameConsole convertToGameConsole(GameConsoleDTO gameConsoleDTO){
        GameConsole gameConsole = new GameConsole();
        gameConsole.setGamePrice(gameConsoleDTO.getGamePrice());

        return gameConsole;
    }
}
