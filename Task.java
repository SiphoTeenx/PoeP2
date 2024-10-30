/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10451114poep2;

import java.util.function.BooleanSupplier;

/**
 *
 * @author RC_Student_lab
 */
public final class Task {
    static int taskCounter;
    static int totalHours;
    private String taskName;
    private int taskNumber;
    private String taskDesc;
    private String devDetails;
    private String taskID;
    private String taskStatus;
    private int duration;

    public Task(String taskName, String taskDesc, String devDetails, double duration, String taskStatus) {
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.devDetails = devDetails;
        this.duration = (int) duration;
        this.taskStatus = taskStatus;
        this.taskNumber = (int) (Math.random() * 1000); // Generate random task number for example
        this.taskID = createTaskID();
    }

    // Getters and setters
    public String getTaskName() { return taskName; }
    public void setTaskName(String taskName) { this.taskName = taskName; }
    public int getTaskNumber() { return taskNumber; }
    public void setTaskNumber(int taskNumber) { this.taskNumber = taskNumber; }
    public String getTaskDesc() { return taskDesc; }
    public void setTaskDesc(String taskDesc) { this.taskDesc = taskDesc; }
    public String getDevDetails() { return devDetails; }
    public void setDevDetails(String devDetails) { this.devDetails = devDetails; }
    public String getTaskID() { return taskID; }
    public void setTaskID(String taskID) { this.taskID = taskID; }
    public String getTaskStatus() { return taskStatus; }
    public void setTaskStatus(String taskStatus) { this.taskStatus = taskStatus; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String createTaskID() {
        return (taskName.substring(0, 2) + ":" + taskNumber + ":" + devDetails.substring(devDetails.length() - 3)).toUpperCase();
    }

    public String printTaskDetails() {
        return String.format("""
                             Task Status: %s
                             Developer Details: %s
                             Task Number: %d
                             Task Description: %s
                             Task ID: %s
                             Duration: %d hours
                             """, taskStatus, devDetails, taskNumber, taskDesc, taskID, duration);
    }

    public double returnTotalHours() {
        return duration;
    }

    BooleanSupplier checkTaskDescription() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   
}
