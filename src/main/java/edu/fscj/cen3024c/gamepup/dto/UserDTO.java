// UserDTO.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.dto;

public class UserDTO {

    private String userFName;
    private String userLName;
    private String userName;
    private String userPassword;
    private String userBirthDate;
    private String phone;
    private String email;

    public UserDTO(){}

    public String getUserFName() {
        return userFName;
    }
    public void setUserFName(String userFName) {

        this.userFName = userFName;
    }

    public String getUserLName() {

        return userLName;
    }
    public void setUserLName(String userLName) {

        this.userLName = userLName;
    }

    public String getUserName() {

        return userName;
    }
    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getUserBirthDate() {

        return userBirthDate;
    }
    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getPhone() {

        return phone;
    }
    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }

    public String getUserPassword() {

        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
