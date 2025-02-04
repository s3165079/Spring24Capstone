// UserRepository.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // search for existing ID
    @Query(
            "" +
                    "SELECT CASE WHEN COUNT(u) > 0 THEN " +
                    "TRUE ELSE FALSE END " +
                    "FROM User u " +
                    "WHERE u.userName = ?1"
    )
    Boolean selectExistsUserName(String userName);

    List<User> findByUserName(String userName);

    Optional<User> findById(Integer userId);

    User findUserByUserName(String userName);


}