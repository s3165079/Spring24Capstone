package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.GameConsole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GameConsoleRepository extends JpaRepository<GameConsole, Integer> {
    //find game by price to specific console
    List<GameConsole> findGameConsoleByGamePrice(BigDecimal gamePrice);
}
