/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chat_app;


/**
 *
 * @author mtswe
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Chat_app {
    public static void main(String[] args) {
        User user = new User();
        Login login = new Login();
        login.register(user);

        if (user.getUsername() == null || user.getPassword() == null) {
            return; // Login failed
        }

        ArrayList<Message> sentMessages = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat!");

        while (true) {
            String menu = JOptionPane.showInputDialog("""
                    Choose an option:
                    1) Send Messages
                    2) Show Recently Sent Messages
                    3) Quit""");

            if (menu == null || menu.equals("3")) break;

            switch (menu) {
                case "1" -> {
                    int numMessages = Integer.parseInt(
                            JOptionPane.showInputDialog("How many messages do you want to send?")
                    );

                    for (int i = 0; i < numMessages; i++) {
                        String recipient = JOptionPane.showInputDialog("Enter recipient phone number (include +country code):");
                        String messageText = JOptionPane.showInputDialog("Enter your message (max 250 chars):");

                        Message msg = new Message(recipient, messageText);

                        if (!msg.checkRecipientCell()) {
                            JOptionPane.showMessageDialog(null, "Invalid recipient phone number.");
                            continue;
                        }

                        if (!msg.checkMessageLength()) {
                            int over = messageText.length() - 250;
                            JOptionPane.showMessageDialog(null,
                                    "Message exceeds 250 characters by " + over + ". Please shorten it.");
                            continue;
                        }

                        String choice = JOptionPane.showInputDialog("""
                                What do you want to do?
                                1) Send Message
                                2) Disregard Message
                                3) Store Message
                                """);

                        String result = msg.sendMessageOption(choice);
                        JOptionPane.showMessageDialog(null, result);

                        if (choice.equals("1")) {
                            sentMessages.add(msg);
                            JOptionPane.showMessageDialog(null, msg.printDetails());
                        } else if (choice.equals("3")) {
                            msg.storeMessage(); // stub
                        }
                    }

                    JOptionPane.showMessageDialog(null,
                            "Total messages sent: " + Message.returnTotalMessages());
                }

                case "2" -> JOptionPane.showMessageDialog(null, "Coming Soon.");

                default -> JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
            }
        }
    }
}

/* Refernce List
    IIE Varasity College
    Chat GPt
*/
