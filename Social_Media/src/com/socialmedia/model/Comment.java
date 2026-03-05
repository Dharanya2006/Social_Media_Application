package com.socialmedia.model;

import java.time.LocalDateTime;

public class Comment {
    private User user;
    private String message;
    private LocalDateTime time;
    public Comment(User user, String message) {
        this.user = user;
        this.message = message;
        this.time = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return user.getName() + ": " + message;
    }
}