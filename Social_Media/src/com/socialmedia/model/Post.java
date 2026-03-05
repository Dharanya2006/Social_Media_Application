package com.socialmedia.model;

import java.time.LocalDateTime;
import java.util.*;

public class Post {
    private int id;
    private User author;
    private String content;
    private LocalDateTime createdAt;
    private Set<User> likes = new HashSet<>();
    private List<Comment> comments = new ArrayList<>();
    public Post(int id, User author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }
    public int getId() {
    	return id; 
    	}
    public User getAuthor() { 
    	return author;
    	}
    public String getContent() { 
    	return content;
    	}
    public LocalDateTime getCreatedAt() { 
    	return createdAt; 
    	}
    public Set<User> getLikes() {
    	return likes;
    	}
    public List<Comment> getComments() { 
    	return comments; 
    	}
    public void like(User user) {
        likes.add(user);
    }
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    @Override
    public String toString() {
        return "Post ID: " + id +
                "\nAuthor: " + author.getName() +
                "\nContent: " + content +
                "\nLikes: " + likes.size();
    }
}