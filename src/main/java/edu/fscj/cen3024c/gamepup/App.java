package edu.fscj.cen3024c.gamepup;

import edu.fscj.cen3024c.gamepup.controller.GameController;
import edu.fscj.cen3024c.gamepup.dto.GameDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
    private final GameController gameController;

    public App(GameController gameController) {
        this.gameController = gameController;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        for (GameDTO gameDTO : gameController.getAllGames().getBody()) {
            System.out.println(gameDTO);
        }
    }
}
