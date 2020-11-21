package com.tts.skepticmoon.models;

import org.springframework.lang.NonNull;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {
    
    @NotEmpty
    private String name;

    @NotEmpty
    private String message;


    @NotEmpty
    @Email
    private String address;

    public User() {
    }

    public User(@NotEmpty String name, @NotEmpty String message, @NotEmpty @Email String address) {
        this.name = name;
        this.message = message;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [address=" + address + ", message=" + message + ", name=" + name + "]";
    }

    
}

