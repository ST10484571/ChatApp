/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supreme_messenger;

/**
 *
 * @author mtswe
 */
public class User {
    
    //Details
    private String name;
    private String surname;
    private String username;
    private String password;
    private String phoneNumber;

    
    //Getter and Setter for Name and Surname
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
    
    //Getters and Setters Login details
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    //Constructors
    public User() {
    }

    public User(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    
    public User(String name, String surname, String username, String password, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}