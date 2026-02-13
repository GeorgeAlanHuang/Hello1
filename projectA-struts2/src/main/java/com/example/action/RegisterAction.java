package com.example.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class RegisterAction extends ActionSupport {
    private String username;
    private String password;
    private String confirmPassword;

    @Action(value = "register", results = {
        @Result(name = "success", location = "/success.jsp"),
        @Result(name = "input", location = "/register.jsp")
    })
    public String execute() {
        if (!isUsernameAvailable(username)) {
            addFieldError("username", "Username already exists.");
            return INPUT;
        }
        if (!password.equals(confirmPassword)) {
            addFieldError("password", "Passwords do not match.");
            return INPUT;
        }
        // Perform registration logic here
        return SUCCESS;
    }

    // Simulated method to check username existence
    private boolean isUsernameAvailable(String username) {
        // This should query the database to check if the username exists
        return true; // Assume username is available for the purpose of this example
    }

    // Getters and setters for username, password, and confirmPassword
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}