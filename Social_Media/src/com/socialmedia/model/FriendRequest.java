package com.socialmedia.model;

public class FriendRequest {
    private User sender;
    private User receiver;
    private String status; 
    public FriendRequest(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.status = "PENDING";
    }
    public User getSender() { 
    	return sender;
    	}
    public User getReceiver() {
    	return receiver;
    	}
    public String getStatus() { 
    	return status; 
    	}
    public void accept() { 
    	status = "ACCEPTED";
    	}
}