/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author mtswe
 */
import com.mycompany.chat_app.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Unit_Test {

    @Test
    public void testValidRecipient() {
        Message msg = new Message("+27831234567", "Test message");
        assertTrue(msg.checkRecipientCell());
    }

    @Test
    public void testInvalidRecipient() {
        Message msg = new Message("0731234567", "Test message");
        assertFalse(msg.checkRecipientCell());
    }

    @Test
    public void testShortMessageIsValid() {
        Message msg = new Message("+27831234567", "Short message");
        assertTrue(msg.checkMessageLength());
    }

    @Test
    public void testTooLongMessageFails() {
        String longText = "a".repeat(251);
        Message msg = new Message("+27831234567", longText);
        assertFalse(msg.checkMessageLength());
    }

    @Test
    public void testCreateMessageHash() {
        Message msg = new Message("+27831234567", "Hi Mike, can you join us for dinner tonight?");
        String hash = msg.createMessageHash();

        assertTrue(hash.matches("\\d{2}:\\d+:HITONIGHT\\?"),
            "Hash should match pattern XX:#:HITONIGHT?");
    }

    @Test
    public void testSendMessageOptionSend() {
        Message msg = new Message("+27831234567", "Hello");
        assertEquals("Message successfully sent.", msg.sendMessageOption("1"));
    }

    @Test
    public void testSendMessageOptionDisregard() {
        Message msg = new Message("+27831234567", "Hello");
        assertEquals("Press 0 to delete message.", msg.sendMessageOption("2"));
    }

    @Test
    public void testSendMessageOptionStore() {
        Message msg = new Message("+27831234567", "Hello");
        assertEquals("Message successfully stored.", msg.sendMessageOption("3"));
    }

    @Test
    public void testSendMessageOptionInvalid() {
        Message msg = new Message("+27831234567", "Hello");
        assertEquals("Invalid choice.", msg.sendMessageOption("x"));
    }

    @Test
    public void testReturnTotalMessagesIncrements() {
        int countBefore = Message.returnTotalMessages();
        new Message("+27830000000", "Test 1");
        new Message("+27830000000", "Test 2");
        int countAfter = Message.returnTotalMessages();

        assertEquals(countBefore + 2, countAfter);
    }
}
