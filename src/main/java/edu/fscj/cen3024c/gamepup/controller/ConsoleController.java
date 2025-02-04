package edu.fscj.cen3024c.gamepup.controller;

import edu.fscj.cen3024c.gamepup.dto.ConsoleDTO;
import edu.fscj.cen3024c.gamepup.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consoles")
public class ConsoleController {
    private final ConsoleService consoleService;

    @Autowired
    public ConsoleController(ConsoleService consoleService){
        this.consoleService = consoleService;
    }

    @GetMapping
    public ResponseEntity<List<ConsoleDTO>> getAllConsoles() {
        List<ConsoleDTO> consoleDTOs = consoleService.getAllConsoleDTOs();
        return ResponseEntity.ok(consoleDTOs);
    }

    @GetMapping("/{consoleId}")
    public ResponseEntity<ConsoleDTO> getConsoleByConsoleId(
      @PathVariable("consoleId") Integer consoleId){
        ConsoleDTO consoleDTO = consoleService.getConsoleDTOByConsoleId(consoleId);
        return ResponseEntity.ok(consoleDTO);
    }

    @GetMapping("/{consoleName}")
    public ResponseEntity<List<ConsoleDTO>> getConsoleByConsoleName(
      @PathVariable("consoleName") String consoleName){
        List<ConsoleDTO> consoleDTOs = consoleService.getConsoleDTOsByConsoleName(consoleName);
        return ResponseEntity.ok(consoleDTOs);
    }
}
