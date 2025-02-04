package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.dto.ConsoleDTO;
import edu.fscj.cen3024c.gamepup.entity.Console;
import org.springframework.stereotype.Component;

@Component
public class ConsoleConverter {

    public ConsoleDTO convertToConsoleDTO(Console console){
        ConsoleDTO consoleDTO = new ConsoleDTO();
        consoleDTO.setConsoleName(console.getConsoleName());

        return consoleDTO;
    }

    public Console convertToConsole(ConsoleDTO consoleDTO){
        Console console = new Console();
        console.setConsoleName(consoleDTO.getConsoleName());

        return console;
    }
}
