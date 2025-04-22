/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.supreme_messenger;

/**
 *
 * @author mtswe
 */
import javax.swing.JOptionPane;

public class Supreme_Messenger {
    public static void main(String[] args) {
        Login login = new Login();

        String registrationMessage = login.registerUser();
        JOptionPane.showMessageDialog(null, registrationMessage);

        if ("User successfully registered!".equals(registrationMessage)) {
            String userInput = JOptionPane.showInputDialog("Enter your username to login:");
            String passInput = JOptionPane.showInputDialog("Enter your password to login:");
            String loginMessage = login.returnLoginStatus(userInput, passInput);
            JOptionPane.showMessageDialog(null, loginMessage);
        }
        
    }
    
}



