/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10451114poep2;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class ST10451114PoeP2 {
    static double totalHours = 0;
    private static final Task[] tasks = new Task[100];
    static int taskCount = 0;

    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        Registration myRegistrationObj = new Registration();

        // Username and password check
        boolean isUsernameValid = myRegistrationObj.checkUsername(cs);
        String username = "";
        String password = "";

        if (isUsernameValid) {
            boolean isPasswordValid = myRegistrationObj.checkPassword(cs);
            if (isPasswordValid) {
                // Capture username and password after validation
                username = myRegistrationObj.getUsername();
                password = myRegistrationObj.getPassword();

                System.out.println("Enter First Name: ");
                String firstName = cs.next();

                System.out.println("Enter Last Name: ");
                String lastName = cs.next();

                boolean isLoginSuccessful = Registration.loginUser(cs, username, password, firstName, lastName);

                if (isLoginSuccessful) {
                    JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
                    
                    int totalTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));

                    
                    while (true) {
                        int choice = Integer.parseInt(JOptionPane.showInputDialog("1. Add tasks\n2. Show report\n3. Quit"));
                        switch (choice) {
                            case 1 -> {
                                if (taskCount < totalTasks) {
                                addTask(firstName + " " + lastName);
                            } else {
                                JOptionPane.showMessageDialog(null, "You have reached the maximum number of tasks.");
                            }
                                }
                        
                            case 2 -> showReport();
                            case 3 -> System.exit(0);
                            default -> JOptionPane.showMessageDialog(null, "Invalid choice");
                        }
                    }
                } else {
                    System.out.println("Login failed. Please check your username and password.");
                }
            }
        }
    }

    // Add task method
    static void addTask(String developerName) {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 chars):");

        if (taskDescription.length() <= 50) {
            double duration = Double.parseDouble(JOptionPane.showInputDialog("Enter Task Duration in hours:"));
            String taskStatus = JOptionPane.showInputDialog("Enter Task Status (To Do/Doing/Done):");

            Task newTask = new Task(taskName, taskDescription, developerName, duration, taskStatus);
            tasks[taskCount++] = newTask;
            totalHours += duration;
            JOptionPane.showMessageDialog(null, newTask.printTaskDetails());
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
        }
    }

    // Show report method
    static void showReport() {
        if (taskCount == 0) {
        // Display "Coming Soon!!!" if no tasks have been added
        JOptionPane.showMessageDialog(null, "Coming Soon!!!");
        return; // Exit the method early
    }
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            report.append(tasks[i].printTaskDetails()).append("\n\n");
        }
        
        report.append("Total hours across all tasks: ").append(totalHours);
        JOptionPane.showMessageDialog(null, report.toString());
        
    }

    short getTaskCount() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
        
    }
