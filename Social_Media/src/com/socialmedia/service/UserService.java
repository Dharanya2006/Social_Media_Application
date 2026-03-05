package com.socialmedia.service;

import com.socialmedia.model.User;
import com.socialmedia.util.IdGenerator;

import java.time.LocalDate;
import java.util.*;
public class UserService {
    private Map<Integer, User> users = new HashMap<>();
    public User register(String name, LocalDate dob, int age, String location, String occupation) {
        int id = IdGenerator.generateUserId();
        User user = new User(id, name, dob, age, location, occupation);
        users.put(id, user);
        return user;
    }
    public User getUser(int id) {
        return users.get(id);
    }
    public Collection<User> getAllUsers() {
        return users.values();
    }
}