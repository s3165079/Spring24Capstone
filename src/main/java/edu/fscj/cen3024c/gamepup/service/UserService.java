// UserService.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.UserConverter;
import edu.fscj.cen3024c.gamepup.dto.UserDTO;
import edu.fscj.cen3024c.gamepup.entity.User;
import edu.fscj.cen3024c.gamepup.repository.UserRepository;
import edu.fscj.cen3024c.gamepup.exceptions.PasswordException;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    // acceptable formats
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\" +
            ".[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PHONE_REGEX = "^(\\+\\d{1,2}\\s?)?\\" +
            "(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
    private static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

    @Autowired
    public UserService(UserRepository userRepository,
                       UserConverter userConverter){
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUserDTOByUserName(String userName) {
        List<User> users = userRepository.findByUserName(userName);
        return users.stream()
                .map(userConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    public Integer getUserIdByUserName(String userName) {
        User user = null;
        List<User> userList = userRepository.findByUserName(userName);
        if(!userList.isEmpty())
            user = userList.get(0);

        return user.getId();
    }

    public User getUserByUserId(Integer userId) {
        User user = null;
        Optional<User> userList = userRepository.findById(userId);
        if(!userList.isEmpty())
            user = userList.get();

        return user;
    }

    private byte[] createSalt() {
        var random = new SecureRandom();
        var salt = new byte[128];
        random.nextBytes(salt);
        return salt;
    }
    private byte[] createPasswordHash(
            String password, byte[] salt)
            throws NoSuchAlgorithmException {
        var md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        return md.digest(
                password.getBytes(StandardCharsets.UTF_8));
    }
    public UserDTO createUser(UserDTO userDTO, String password)
            throws NoSuchAlgorithmException,
            BadRequestException {
        var user = userConverter.convertToUser(userDTO);
        if (password.isBlank()) throw new IllegalArgumentException(
                "Password is required.");
        if (!passCheck(password))throw new PasswordException(
                "Password is too weak.");

        // verify proper patterns
        if (!isValidEmail(user.getEmail()))
            throw new BadRequestException("Invalid email address. " +
                    "Please check the email address and re-enter.");
        if (!isValidPhone(user.getPhone()))
            throw new BadRequestException("Invalid phone number. " +
                    "Format: ###-###-####");
        if (!isValidDate(user.getUserBirthDate()))
            throw new BadRequestException("Invalid date format. " +
                    "Format: yyyy/mm/dd");

        // ... code to check if user already exists
        if (userRepository.selectExistsUserName(user.getUserName())) {
            throw new BadRequestException("user already exists");
        }
        byte[] salt = createSalt();
        byte[] hashedPassword = createPasswordHash(password, salt);
        user.setStoredSalt(salt);
        user.setStoredHash(hashedPassword);
        userRepository.save(user);
        return userConverter.convertToDTO(user);
    }


    public UserDTO changePassword(String userName, String newPassword,
                                  String oldPassword)
            throws NoSuchAlgorithmException, BadRequestException {
        User user = userRepository.findUserByUserName(userName);

        byte[] oldPasswordHash = createPasswordHash(
                oldPassword,user.getStoredSalt());

        if (!MessageDigest.isEqual(user.getStoredHash(), oldPasswordHash))
            throw new BadRequestException("wrong password");

        if (newPassword.isBlank()) throw new IllegalArgumentException(
                "Password is required.");
        if (!passCheck(newPassword))throw new PasswordException(
                "Password is too weak.");

        byte[] salt = createSalt();
        byte[] hashedPassword = createPasswordHash(newPassword, salt);
        user.setStoredSalt(salt);
        user.setStoredHash(hashedPassword);
        userRepository.save(user);
        return userConverter.convertToDTO(user);
    }


    public boolean passCheck(String password) throws BadRequestException {

        boolean check = false;

        if (containsLength(password) &&
            containsUpperCase(password) &&
            containsLowerCase(password) &&
            containsSymbol(password)&&
            containsDigit(password)){
                check = true;
        }

        return check;
    }

    // throw for each error to let user know why password is weak
    private boolean containsLength(String pw) throws BadRequestException {
        if (pw.length() <= 10) {
            throw new PasswordException(
                    "The password must be more than 10 characters.");
        }
        return true;
    }

    private boolean containsUpperCase(String pw) throws BadRequestException {
        for (char c : pw.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        throw new PasswordException(
                "The password must contain an upper case letter.");
    }

    private boolean containsLowerCase(String pw) throws BadRequestException {
        for (char c : pw.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        throw new PasswordException(
                "The password must contain a lower case letter.");
    }

    private boolean containsSymbol(String pw) throws BadRequestException {
        String allowedSymbols = "!@#$%^&*()";
        for (char c : pw.toCharArray()) {
            if (allowedSymbols.indexOf(c) != -1) {
                return true;
            }
        }
        throw new PasswordException(
                "The password must contain a special character.");
    }
    private boolean containsDigit(String pw) throws BadRequestException {
        for (char c : pw.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        throw new PasswordException(
                "The password must contain a number.");
    }

    public UserDTO changeUserName(String userName, String newUserName)
            throws BadRequestException {
        User user = userRepository.findUserByUserName(userName);
        if (newUserName.isBlank()) throw new IllegalArgumentException(
                "A user name is required.");
        // ... code to check if user already exists
        if (userRepository.selectExistsUserName(newUserName)) {
            throw new BadRequestException("user name already exists");
        }
        user.setUserName(newUserName);
        userRepository.save(user);
        return userConverter.convertToDTO(user);
    }

    public UserDTO changeEmail(String userName, String newEmail)
            throws BadRequestException {
        User user = userRepository.findUserByUserName(userName);

        if (newEmail.isBlank())
            throw new BadRequestException("An email is required.");
        user.setEmail(newEmail);

        if (!isValidEmail(newEmail))
            throw new BadRequestException("Invalid email address." +
                    "Please check the email address and re-enter.");

        userRepository.save(user);
        return userConverter.convertToDTO(user);
    }

    // format checkers
    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    private boolean isValidDate(String date) {
        Pattern pattern = Pattern.compile(DATE_REGEX);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
