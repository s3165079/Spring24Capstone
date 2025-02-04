// UserController.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.controller;

import edu.fscj.cen3024c.gamepup.dto.UserDTO;
import edu.fscj.cen3024c.gamepup.service.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userName}")
    public ResponseEntity<List<UserDTO>> getUserDTOByUserName(
            @PathVariable(value = "userName") String userName) {
        List<UserDTO> userDTO = userService.getUserDTOByUserName(userName);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO postUser(@Valid @RequestBody UserDTO userDTO)
            throws NoSuchAlgorithmException, BadRequestException {
        return userService.createUser(userDTO, userDTO.getUserPassword());
    }


    //change password
    @PostMapping("/changePassword")
    public UserDTO changePassword (
            @RequestParam("userName") String userName,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword)
            throws NoSuchAlgorithmException, BadRequestException {
        return userService.changePassword(userName, newPassword, oldPassword);
    }

    // change username
    @PostMapping("/changeUserName")
    public UserDTO changeUserName (
            @RequestParam("userName") String userName,
            @RequestParam("newUserName") String newUserName)
            throws NoSuchAlgorithmException, BadRequestException {
        return userService.changeUserName(userName, newUserName);
    }

    //change email
    @PostMapping("/changeEmail")
    public UserDTO changeEmail(
            @RequestParam("userName") String userName,
            @RequestParam("newEmail") String newEmail) throws BadRequestException {

        return userService.changeEmail(userName, newEmail);

    }
}
