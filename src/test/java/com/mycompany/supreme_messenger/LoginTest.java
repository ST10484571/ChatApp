/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.supreme_messenger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class LoginTest {

    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName() {
        Login login = new Login(); // Use the no-argument constructor

        // Test a valid username
        assertTrue(login.checkUserName("kyl_1"));

        // Test an invalid username (too long, no underscore)
        assertFalse(login.checkUserName("kyle!!!!!!!"));
        // Test another invalid username (too long)
         assertFalse(login.checkUserName("kyle_long"));
        // Test another invalid username (no underscore)
        assertFalse(login.checkUserName("kyle1"));
         // Test another invalid username (null)
        assertFalse(login.checkUserName(null));
         // Test another invalid username (empty)
        assertFalse(login.checkUserName(""));
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login(); // Use the no-argument constructor

        // Test a valid password
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));

        // Test invalid passwords
        assertFalse(login.checkPasswordComplexity("password")); // Too short, no capital, no number, no special char
        assertFalse(login.checkPasswordComplexity("Password123")); // No special char
        assertFalse(login.checkPasswordComplexity("PASSWORD!!!")); // No lowercase, no number
        assertFalse(login.checkPasswordComplexity("password!!!")); // No capital, no number
        assertFalse(login.checkPasswordComplexity("Pass1")); // Too short
         assertFalse(login.checkPasswordComplexity(null)); // null
          assertFalse(login.checkPasswordComplexity("")); // empty
    }

    /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellPhoneNumber() {
        Login login = new Login(); // Use the no-argument constructor

        // Test valid phone numbers
        assertTrue(login.checkCellPhoneNumber("+27831234567"));
        assertTrue(login.checkCellPhoneNumber("+15551234567")); // Another valid format

        // Test invalid phone numbers
        assertFalse(login.checkCellPhoneNumber("08966553")); // No plus sign, too short
        assertFalse(login.checkCellPhoneNumber("+2783123456789012")); // Too long
        assertFalse(login.checkCellPhoneNumber("+27ABCDEFG")); // Contains non-digits after plus
        assertFalse(login.checkCellPhoneNumber("27831234567")); // No plus sign
        assertFalse(login.checkCellPhoneNumber(null)); // null
         assertFalse(login.checkCellPhoneNumber("")); // empty
    }

    // Note: Testing registerUser and returnLoginStatus would require
    // mocking JOptionPane or refactoring the Login class to inject
    // input/output dependencies, which is beyond fixing the current test structure.
    // The provided LoginTest only covers the check methods.
}