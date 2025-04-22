/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supreme_messenger;

/**
 *
 * @author mtswe
 */
import javax.swing.JOptionPane;

// Login Class
public class Login {
    private User user;

    public Login() {
        this.user = new User();  //user object
    }

    // Check username
    public boolean checkUserName(String username) {
        return username != null
            && username.contains("_")
            && username.length() <= 5;
    }

    // Check password complexity
    public boolean checkPasswordComplexity(String password) {
        return password != null
            && password.length() >= 8
            && password.matches(".*[A-Z].*")
            && password.matches(".*[0-9].*")
            && password.matches(".*[^a-zA-Z0-9].*");
        //OpenAI. (2023). ChatGPT (Mar 14 version) [Large language model]. 
    }

    // Check cellphoneNumber
    public boolean checkCellPhoneNumber(String number) {
        return number != null
            && number.startsWith("+")
            && number.length() <= 14
            && number.substring(1).matches("\\d{1,14}");
        //OpenAI. (2023). ChatGPT (Mar 14 version) [Large language model].
    }

    // User registration (Registration will be cancelled if nothing is entered
    public String registerUser() {
        //Name and Surname
        String name = JOptionPane.showInputDialog("Enter your name:");
            //Cancel registration
        if (name == null) return "Registration cancelled.";
        user.setName(name);

        String surname = JOptionPane.showInputDialog("Enter your surname:");
            //Cancel registration
        if (surname == null) return "Registration cancelled.";
        user.setSurname(surname);

        String username = JOptionPane.showInputDialog(
            "Create a username for " + name + " " + surname +
            "\n(must contain an underscore and be no more than 5 characters)");
            //Cancel registration
        if (username == null) return "Registration cancelled.";
        if (!checkUserName(username)) {
            return "Username is incorrectly formatted.";
        }
        user.setUsername(username);

        String password = JOptionPane.showInputDialog(
            "Create a password for " + name + " " + surname +
            "\nPassword must contain 8 or more characters, a capital letter, a number, and a special character.");
        if (password == null) return "Registration cancelled.";
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet the complexity requirements.";
        }
        user.setPassword(password);

        String phoneNumber = JOptionPane.showInputDialog(
            "Enter your phone number (include country code, e.g. +27...)");
        if (phoneNumber == null) return "Registration cancelled.";
        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Phone number is not valid. Must include country code and up to 14 digits.";
        }
        user.setPhoneNumber(phoneNumber);

        return "User successfully registered!";
    }

    // Check if login details match with created ones
    public boolean loginUser(String loginUsername, String loginPassword) {
        return loginUsername != null
            && loginPassword != null
            && loginUsername.equals(user.getUsername())
            && loginPassword.equals(user.getPassword());
    }

    // Return a message
    public String returnLoginStatus(String loginUsername, String loginPassword) {
        if (loginUser(loginUsername, loginPassword)) {
            return "Welcome back " + user.getName() + " " + user.getSurname() +
                   "! It's great to see you again.";
        } else {
            return "Username or password is incorrect, please try again.";
        }
    }
}