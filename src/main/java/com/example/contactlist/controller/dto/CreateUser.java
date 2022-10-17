package com.example.contactlist.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CreateUser {
    @NotEmpty
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty
    @Size(min = 5, message = "Password must be a minimum of 5 characters in length")
    private String password;

    public CreateUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
