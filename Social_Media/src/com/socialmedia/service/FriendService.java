package com.socialmedia.service;

import com.socialmedia.model.*;

public class FriendService {

    public void sendRequest(User sender, User receiver) {
        FriendRequest request = new FriendRequest(sender, receiver);
        sender.getSentRequests().add(request);
        receiver.getReceivedRequests().add(request);
        receiver.getNotifications().add(
                new Notification(sender.getName() + " sent you a friend request.")
        );
    }
    public void acceptRequest(FriendRequest request) {
        request.accept();
        User sender = request.getSender();
        User receiver = request.getReceiver();
        sender.addFriend(receiver);
        receiver.addFriend(sender);
        sender.getNotifications().add(
                new Notification(receiver.getName() + " accepted your friend request."));
    }
}