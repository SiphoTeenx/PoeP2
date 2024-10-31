/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.st10451114poep2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class RegistrationTest {
    
    public RegistrationTest() {
    }

     public void testLoginUser() {

    Register register = new egister();
    String validUsername = "kyl_1";
    String invalidUsername = "kyle!!!!!!!!!!";
    String validPassword = "Ch&&sec@ke99!";
    String invalidPassword = "password";

 // Test successful login
        register.registerUser(validUsername, validPassword); // Register the user first
        boolean loginSuccess = register.loginUser(validUsername, validPassword);
        System.out.println("Login successful: " + loginSuccess);
        assertTrue(loginSuccess, "The system returns: True");

        // Test unsuccessful login with incorrect password
        boolean loginFailed = register.loginUser(validUsername, invalidPassword);
        System.out.println("Login failed: " + loginFailed);
        assertFalse(loginFailed, "The system returns: False");

        // Test username correctly formatted
        boolean usernameCorrectFormat = register.checkUsername(validUsername);
        System.out.println("Username correctly formatted: " + usernameCorrectFormat);
        assertTrue(usernameCorrectFormat, "The system returns: True");

        // Test username incorrectly formatted
        boolean usernameIncorrectFormat = register.checkUsername(invalidUsername);
        System.out.println("Username incorrectly formatted: " + usernameIncorrectFormat);
        assertFalse(usernameIncorrectFormat, "The system returns: False");

        // Test password meets complexity requirements
        boolean passwordMeetsComplexity = register.checkPassword(validPassword);
        System.out.println("Password meets complexity requirements: " + passwordMeetsComplexity);
        assertTrue(passwordMeetsComplexity, "The system returns: True");

        // Test password does not meet complexity requirements
        boolean passwordDoesNotMeetComplexity = register.checkPassword(invalidPassword);
        System.out.println("Password does not meet complexity requirements: " + passwordDoesNotMeetComplexity);
        assertFalse(passwordDoesNotMeetComplexity, "The system returns: False");
    }

    // Test successful login
    boolean loginSuccess = register.loginUser(validUsername, validPassword, validUsername, validPassword);
    System.out.println("Login successful: " + loginSuccess);
    assertEquals(true, loginSuccess, "Login should be successful when correct credentials are provided");

    // Test unsuccessful login (wrong password)
    boolean loginFailurePassword = register.loginUser(validUsername, invalidPassword, validUsername, validPassword);
    System.out.println("Login failure password: " + loginFailurePassword);
    assertEquals(false, loginFailurePassword, "Login should fail with incorrect password");

    // Test unsuccessful login (wrong username)
    boolean loginFailureUsername = register.loginUser(invalidUsername, validPassword, validUsername, validPassword);
    System.out.println("Login failure username: " + loginFailureUsername);
    assertEquals(false, loginFailureUsername, "Login should fail with incorrect username");

    // Test unsuccessful login (both username and password wrong)
    boolean loginFailureBoth = register.loginUser(invalidUsername, invalidPassword, validUsername, validPassword);
    System.out.println("Login failure both: " + loginFailureBoth);
    assertEquals(false, loginFailureBoth, "Login should fail with incorrect username and password");
}
    // Helper methods for assertions
    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }
    
}
