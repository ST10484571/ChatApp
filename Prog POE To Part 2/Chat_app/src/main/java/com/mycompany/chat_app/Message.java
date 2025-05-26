/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat_app;

/**
 *
 * @author mtswe
 */
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JOptionPane;

public class Message {

    private static int messageCount = 0;
    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;

    public Message(String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.messageText = messageText;
        messageCount++;
        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {
        Random rand = new Random();
        return String.format("%010d", rand.nextInt(1_000_000_000));
    }

    public boolean checkRecipientCell() {
        return recipient.startsWith("+") && recipient.length() <= 13;
    }

    public boolean checkMessageLength() {
        return messageText.length() <= 250;
    }

    public String createMessageHash() {
        String[] words = messageText.trim().split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        return messageID.substring(0, 2) + ":" + messageCount + ":" + (firstWord + lastWord).toUpperCase();
    }

    public String sendMessageOption(String choice) {
        switch (choice) {
            case "1":
                return "Message successfully sent.";
            case "2":
                return "Press 0 to delete message.";
            case "3":
                return "Message successfully stored.";
            default:
                return "Invalid choice.";
        }
    }

    public String printDetails() {
        return "Message ID: " + messageID + "\nMessage Hash: " + messageHash +
               "\nRecipient: " + recipient + "\nMessage: " + messageText;
    }

    public static int returnTotalMessages() {
        return messageCount;
    }

    // extra method.
    

public void storeMessage() {
    try {
        // Path to the JSON file
        String filePath = "messages.json";
        File file = new File(filePath);

        JSONArray messageList;

        // If the file exists, read its current content
        if (file.exists()) {
            String content = Files.readString(file.toPath());
            messageList = new JSONArray(content.isEmpty() ? "[]" : content);
        } else {
            messageList = new JSONArray();
        }

        // Promted Chatgpt to teach me how to Create new JSON object to store the messages sent
        JSONObject json = new JSONObject();
        json.put("MessageID", messageID);
        json.put("Recipient", recipient);
        json.put("Message", messageText);
        json.put("Hash", messageHash);

        // Add new message to list
        messageList.put(json);

        // Write back to file
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(messageList.toString(2)); // pretty print
        }

        JOptionPane.showMessageDialog(null,"Message successfully saved to messages.json");

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null,"Error saving message: " + e.getMessage());
    }
}

}
