package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.GameConsoleConverter;
import edu.fscj.cen3024c.gamepup.dto.GameConsoleDTO;
import edu.fscj.cen3024c.gamepup.entity.GameConsole;
import edu.fscj.cen3024c.gamepup.repository.GameConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameConsoleService {
    private final GameConsoleRepository gameConsoleRepository;
    private final GameConsoleConverter gameConsoleConverter;

    @Autowired
    public GameConsoleService(GameConsoleRepository gameConsoleRepository,
                              GameConsoleConverter gameConsoleConverter){
        this.gameConsoleRepository = gameConsoleRepository;
        this.gameConsoleConverter = gameConsoleConverter;
    }

    public List<GameConsoleDTO> getAllGameConsoleDTOs() {
        List<GameConsole> gameConsoles = gameConsoleRepository.findAll();
        return gameConsoles.stream().map(gameConsoleConverter::convertToGameConsoleDTO)
          .collect(Collectors.toList());
    }
}
