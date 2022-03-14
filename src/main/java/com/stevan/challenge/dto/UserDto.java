package com.stevan.challenge.dto;

import com.stevan.challenge.entity.User;

import java.io.Serializable;

public class UserDto implements Serializable {

    private String name;
    private String email;
    private Boolean notify;

    public UserDto(String name, String email, Boolean notify) {
        this.name = name;
        this.email = email;
        this.notify = notify;
    }

    public UserDto(User user) {
        this.name = user.getName();
        this.email = user.getMail();
        this.notify = user.isNotify();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getNotify() {
        return notify;
    }

    public void setNotify(Boolean notify) {
        this.notify = notify;
    }
}
