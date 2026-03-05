package com.socialmedia.model;

public class Notification {
    private String message;
    private boolean seen = false;
    public Notification(String message) {
        this.message = message;
    }
    public String getMessage() { 
    	return message;
    	}
    public boolean isSeen() { 
    	return seen; 
    	}
    public void markSeen() {
    	seen = true;
    	}
    @Override
    public String toString() {
        return message;
    }
}