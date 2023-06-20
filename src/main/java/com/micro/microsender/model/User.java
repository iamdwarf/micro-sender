package com.micro.microsender.model;

import com.micro.microsender.MicroSenderApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class User implements Comparable<User> {
    private String name;
    private String surname;
    private String message;
    private static Map<User, List<String>> userMessages = new HashMap<User,List<String>>();
    private static final Logger logger = LogManager.getLogger(MicroSenderApplication.class);

    public User() {
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname, String message) {
        this.name = name;
        this.surname = surname;
        this.message = message;
        addMessagesToMap();
    }

    public void addMessagesToMap(){
        if (userMessages.isEmpty()) {
            userMessages.put(new User(this.name, this.surname), Arrays.asList(this.message));
            logger.info("user is added into the empty list: ", this);
        }
        else {
            for(Iterator<Map.Entry<User,List<String>>> iterator = userMessages.entrySet().iterator(); iterator.hasNext();){
                Map.Entry<User,List<String>> entry = iterator.next();
                User key = entry.getKey();
                if((key.getSurname().equals(this.surname) &&
                        key.getName().equals(this.name))){

                    logger.info("existing user: ", this);
                    List<String> messagesList = entry.getValue();

                    // -------------------------------- //

                    List<String> merged = new ArrayList<>();
                    merged.addAll(messagesList);

                    // --------------------------------- //

                    System.out.println("info: " + this + " " + merged.size());
                    entry.setValue(merged);
                    for(String m: merged){
                        System.out.println("message: " + m);
                    }
                    userMessages.put(key,merged);
                } else {
                    logger.info("not existing user: ", this);
                    userMessages.put(new User(this.name, this.surname), Arrays.asList(this.message));
                }
            }
        }
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

    public static Map<User, List<String>> getUserMessages() {
        return userMessages;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public int compareTo(User user) {
        // if the string are not equal
        if (this.name.compareTo(user.name) != 0) {
            return this.name.compareTo(user.name);
        } else
        if(this.surname.compareTo(user.surname) != 0){
            return this.surname.compareTo(user.surname);
        }
        return -1;
    }
}
