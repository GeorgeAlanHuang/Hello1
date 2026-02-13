package com.example.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;
    
    @Action(value = "login", results = { 
        @Result(name = SUCCESS, location = "/welcome.jsp"),
        @Result(name = ERROR, location = "/login.jsp")
    })
    public String execute() {
        // Validate username and password against the database
        if (isValidUser(username, password)) {
            return SUCCESS;
        } else {
            addActionError("Invalid username or password.");
            return ERROR;
        }
    }
    
    public boolean isValidUser(String username, String password) {
        // Here you would typically fetch the user data from a database
        // This is a placeholder for actual database validation logic
        return "admin".equals(username) && "admin123".equals(password);
    }
    
    // Getters and Setters
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
}