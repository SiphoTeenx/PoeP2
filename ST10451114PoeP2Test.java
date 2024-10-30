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
public class ST10451114PoeP2Test {
    
    /**
     *
     */
    public ST10451114PoeP2Test() {
        {

    String taskDescription;
     int[] taskDuration;
     int counter;

    // Method to check task description length
    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    // Tests for task description validation
    @Test
    public void testCheckTaskDescription_success_Robyn() {
        String description = "Create login to authenticate users.";
        boolean result = checkTaskDescription(description);
        assertTrue(result, "Description should be valid");
    }

    @Test
    public void testCheckTaskDescription_success_Mike() {
        String description = "Create login to authenticate users.";
        boolean result = checkTaskDescription(description);
        assertTrue(result, "Description should be valid");
    }

    @Test
    public void testCheckTaskDescription_failure() {
        String description = "Please enter task description of less than 50 characters because this is too long.";
        boolean result = checkTaskDescription(description);
        assertFalse(result, "Description should be invalid");
    }

    // Method to create a Task ID
    public String createTaskID(String taskName, int taskNumber, String developerDetails) {
        String taskNamePart = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String developerPart = developerDetails.length() >= 3
                ? developerDetails.substring(developerDetails.length() - 3).toUpperCase()
                : developerDetails.toUpperCase();
        return taskNamePart + ":" + taskNumber + ":" + developerPart;
    }

    // Tests for Task ID generation
    @Test
    public void testCreateTaskID_Robyn() {
        String name = "Login Feature";
        int number = 0;
        String developer = "Robyn Harrison";
        String expectedTaskID = "LO:0:SON";
        String actualTaskID = createTaskID(name, number, developer);
        assertEquals(expectedTaskID, actualTaskID, "Task ID should match expected format");
    }

    @Test
    public void testCreateTaskID_Mike() {
        String name = "Add Task Feature";
        int number = 1;
        String developer = "Mike Smith";
        String expectedTaskID = "AD:1:ITH";
        String actualTaskID = createTaskID(name, number, developer);
        assertEquals(expectedTaskID, actualTaskID, "Task ID should match expected format");
    }

    // Method to return total hours
    public int returnTotalHours() {
        int totalHours = 0;
        for (int i = 0; i < counter; i++) {
            totalHours += taskDuration[i];
        }
        return totalHours;
    }

    // Test for total hours calculation
    @Test
    public void testReturnTotalHours(int counter) {
        // Initialize taskDuration with sample values
        int[] taskDuration = new int[]{10, 12, 55, 11, 1};
        counter = 5;

        int expectedTotalHours = 10 + 12 + 55 + 11 + 1;
        int actualTotalHours = returnTotalHours();
        assertEquals(expectedTotalHours, actualTotalHours, "Total hours should match expected sum");
    }
}
  65 changes: 45 additions & 20 deletions65  
src/test/java/com/mycompany/poe1/registerTest.java
Original file line number	Diff line number	Diff line change
@@ -64,29 +64,54 @@ public void testCheckPasswordComplexity() {
    // Test for login success and failure
  @Test
public void testLoginUser() 
{
    register register = new register();
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