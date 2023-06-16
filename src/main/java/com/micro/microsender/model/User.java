package com.micro.microsender.model;

import org.springframework.stereotype.Component;

public class User {
    private String name;
    private String surname;
    private String message;

    public User() {
    }

    public User(String name, String surname, String message) {
        this.name = name;
        this.surname = surname;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
