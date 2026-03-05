package com.socialmedia.model;

import java.time.LocalDate;
import java.util.*;

public class User {
    private int id;
    private String name;
    private LocalDate dob;
    private int age;
    private String location;
    private String occupation;
    private Set<User> friends = new HashSet<>();
    private List<FriendRequest> receivedRequests = new ArrayList<>();
    private List<FriendRequest> sentRequests = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private List<Notification> notifications = new ArrayList<>();
    public User(int id, String name, LocalDate dob, int age, String location, String occupation) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.location = location;
        this.occupation = occupation;
    }
    public int getId() {
    	return id;
    	}
    public String getName() { 
    	return name; 
    	}
    public LocalDate getDob() { 
    	return dob; 
    	}
    public int getAge() {
    	return age;
    	}
    public String getLocation() {
    	return location;
    	}
    public String getOccupation() { 
    	return occupation;
    	}
    public Set<User> getFriends() {
    	return friends; 
    	}
    public List<FriendRequest> getReceivedRequests() {
    	return receivedRequests; 
    	}
    public List<FriendRequest> getSentRequests() {
    	return sentRequests; 
    	}
    public List<Post> getPosts() {
    	return posts; 
    	}
    public List<Notification> getNotifications() {
    	return notifications; 
    	}
    public void addFriend(User user) {
        friends.add(user);
    }
    @Override
    public String toString() {
        return id + " - " + name + " | Age: " + age + " | " + location + " | " + occupation;
    }
}