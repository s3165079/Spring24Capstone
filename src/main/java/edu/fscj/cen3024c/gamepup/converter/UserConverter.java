// UserConverter.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.converter;

import org.springframework.stereotype.Component;

import edu.fscj.cen3024c.gamepup.dto.UserDTO;
import edu.fscj.cen3024c.gamepup.entity.User;

@Component
public class UserConverter {

    // User to DTO
    public UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();

        dto.setPhone(user.getPhone());
        dto.setEmail(user.getEmail());
        dto.setUserBirthDate(user.getUserBirthDate());
        dto.setUserName(user.getUserName());
        dto.setUserFName(user.getUserFName());
        dto.setUserLName(user.getUserLName());

        return dto;
    }

    // DTO to User
    public User convertToUser(UserDTO dto) {
        User user = new User();

        user.setIsMinor(dto.getUserBirthDate());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setUserBirthDate(dto.getUserBirthDate());
        user.setUserName(dto.getUserName());
        user.setUserFName(dto.getUserFName());
        user.setUserLName(dto.getUserLName());

        return user;
    }
}
