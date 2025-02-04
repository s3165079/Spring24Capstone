// User.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_data")
public class
User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<UserGame> userGame;

    @Column(name = "user_fname", nullable = false)
    private String userFName;

    @Column(name = "user_lname", nullable = false)
    private String userLName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_birth_date", nullable = false)
    private String userBirthDate;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_is_minor", nullable = false)
    private Boolean isMinor;

    @Column(name = "stored_hash", nullable = false)
    private byte[] storedHash;

    @Column(name = "stored_salt", nullable = false)
    private byte[] storedSalt;

    public Integer getId() { return id; }

    public String getUserFName() {
        return userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getStoredHash() { return storedHash; }

    public byte[] getStoredSalt() { return storedSalt; }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) { this.id = id; }


    public void setIsMinor(String birthDay) {

        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.parse(birthDay);

        long age = ChronoUnit.YEARS.between(birthDate, today);
        long adultAge = 18;

        if (age >= adultAge)
            this.isMinor = false;
        else
            this.isMinor = true;
    }

    public void setStoredHash(byte[] storedHash) { this.storedHash = storedHash; }

    public void setStoredSalt(byte[] storedSalt) { this.storedSalt = storedSalt; }

    private byte[] createSalt() {
        var random = new SecureRandom();
        var salt = new byte[128];
        random.nextBytes(salt);
        return salt;
    }

    private byte[] createPasswordHash(
            String userPassword, byte[] salt)
            throws NoSuchAlgorithmException {
        var md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        return md.digest(
                userPassword.getBytes(StandardCharsets.UTF_8));
    }


    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o)
            result = true;
        else if (o != null && getClass() == o.getClass()) {
            User user = (User) o;
            result = (id == user.id) &&
                    Objects.equals(userLName, user.userLName) &&
                    Objects.equals(userFName, user.userFName) &&
                    Objects.equals(userName, user.userName) &&
                    userBirthDate.equals(user.userBirthDate) &&
                    Objects.equals(phone, user.phone) &&
                    Objects.equals(email, user.email) &&
                    isMinor == user.isMinor;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userFName, userLName, userName, userBirthDate, phone, isMinor);
    }

    @Override
    public String toString() {
        return "User {" +
                "User ID=" + id +
                ", lastName='" + userLName + '\'' +
                ", firstName='" + userFName + '\'' +
                ", userName='" + userName + '\'' +
                ", birthdate='" + userBirthDate + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", minor='" + isMinor + '\'' +
                " }";
    }
}