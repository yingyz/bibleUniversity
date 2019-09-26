package com.cpp.bible.Requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserSignUpRequest {

    @NotBlank(message = "User Name Cannot be Blank")
    @Email
    private String username;

    @NotBlank(message = "Password Name Cannot be Blank")
    @Size(min = 6)
    private String password;

    @NotBlank(message = "First Name Cannot be Blank")
    private String firstname;

    @NotBlank(message = "Last Name Cannot be Blank")
    private String lastname;

    @NotBlank(message = "Chinese Name Cannot be Blank")
    private String chinesename;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getChinesename() {
        return chinesename;
    }

    public void setChinesename(String chinesename) {
        this.chinesename = chinesename;
    }
}
