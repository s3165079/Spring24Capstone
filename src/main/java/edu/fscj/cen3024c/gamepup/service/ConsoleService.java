package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.ConsoleConverter;
import edu.fscj.cen3024c.gamepup.dto.ConsoleDTO;
import edu.fscj.cen3024c.gamepup.entity.Console;
import edu.fscj.cen3024c.gamepup.exceptions.ResourceNotFoundException;
import edu.fscj.cen3024c.gamepup.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsoleService {
    private final ConsoleRepository consoleRepository;
    private final ConsoleConverter consoleConverter;

    @Autowired
    public ConsoleService(ConsoleRepository consoleRepository,
                          ConsoleConverter consoleConverter){
        this.consoleRepository = consoleRepository;
        this.consoleConverter = consoleConverter;
    }

    public List<ConsoleDTO> getAllConsoleDTOs() {
        List<Console> consoles = consoleRepository.findAll();
        return consoles.stream().map(consoleConverter::convertToConsoleDTO)
          .collect(Collectors.toList());
    }

    public ConsoleDTO getConsoleDTOByConsoleId(Integer consoleId){
        Console console = consoleRepository.findByConsoleId(consoleId)
          .orElseThrow(() -> new ResourceNotFoundException(
            "Console not found with console id: " + consoleId
          ));
        return consoleConverter.convertToConsoleDTO(console);
    }

    public List<ConsoleDTO> getConsoleDTOsByConsoleName(String consoleName){
        List<Console> consoles = consoleRepository.findByConsoleName(consoleName);
        return consoles.stream().map(consoleConverter::convertToConsoleDTO)
          .collect(Collectors.toList());
    }
}
