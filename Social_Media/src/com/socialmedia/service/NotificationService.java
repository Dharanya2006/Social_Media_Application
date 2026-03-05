package com.socialmedia.service;

import com.socialmedia.model.*;
public class NotificationService {
    public void viewNotifications(User user) {
        if (user.getNotifications().isEmpty()) {
            System.out.println("No new notifications.");
            return;
        }
        for (Notification n : user.getNotifications()) {
            System.out.println(n.getMessage());
            n.markSeen();
        }
        user.getNotifications().removeIf(Notification::isSeen);
    }
}