package com.example.securingweb;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserForm {
    @NotNull
    @Size(min = 3, max = 16)
    private String username;

    @NotNull
    @Size(min = 6, max = 64)
    private String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

}
