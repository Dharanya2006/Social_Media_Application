package com.socialmedia.main;

import com.socialmedia.model.*;
import com.socialmedia.service.*;

import java.time.LocalDate;
import java.util.*;

public class SocialMediaApplication {
    static Scanner sc = new Scanner(System.in);
    static UserService userService = new UserService();
    static FriendService friendService = new FriendService();
    static PostService postService = new PostService();
    static NotificationService notificationService = new NotificationService();
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Register\n2.Login\n3.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> System.exit(0);
            }
        }
    }
    static void register() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("DOB (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(sc.nextLine());
        System.out.print("Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Location: ");
        String location = sc.nextLine();
        System.out.print("Occupation: ");
        String occupation = sc.nextLine();
        User user = userService.register(name, dob, age, location, occupation);
        System.out.println("Registered! ID: " + user.getId());
    }
    static void login() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt(); sc.nextLine();
        User user = userService.getUser(id);
        if (user == null) {
            System.out.println("Invalid ID.");
            return;
        }
        while (true) {
            System.out.println("\n1.View Friends");
            System.out.println("2.Send Friend Request");
            System.out.println("3.View Friend Requests");
            System.out.println("4.Create Post");
            System.out.println("5.View Feed");
            System.out.println("6.View Notifications");
            System.out.println("7.Logout");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    user.getFriends().forEach(System.out::println);
                    break;
                case 2:
                    userService.getAllUsers().forEach(System.out::println);
                    System.out.print("Enter receiver ID: ");
                    int rid = sc.nextInt(); sc.nextLine();
                    User receiver = userService.getUser(rid);
                    if (receiver != null && receiver != user) {
                        friendService.sendRequest(user, receiver);
                        System.out.println("Request sent.");
                    }
                    break;
                case 3:
                    for (FriendRequest fr : user.getReceivedRequests()) {
                        if (fr.getStatus().equals("PENDING")) {
                            System.out.println("From: " + fr.getSender().getName());
                            friendService.acceptRequest(fr);
                            System.out.println("Accepted.");
                        }
                    }
                    break;
                case 4:
                    System.out.print("Post content: ");
                    String content = sc.nextLine();
                    postService.createPost(user, content);
                    System.out.println("Posted!");
                    break;

                case 5:
                    List<Post> feed = postService.getFeed(user);
                    for (Post p : feed) {
                        System.out.println("\n" + p);
                        System.out.println("1.Like  2.Comment  3.Skip");
                        int action = sc.nextInt(); sc.nextLine();
                        if (action == 1) {
                            p.like(user);
                            p.getAuthor().getNotifications().add(
                                    new Notification(user.getName() + " liked your post.")
                            );
                        } else if (action == 2) {
                            System.out.print("Comment: ");
                            String msg = sc.nextLine();
                            p.addComment(new Comment(user, msg));
                            p.getAuthor().getNotifications().add(
                                    new Notification(user.getName() + " commented on your post.")
                            );
                        }
                    }
                    break;
                case 6:
                    notificationService.viewNotifications(user);
                    break;
                case 7:
                    return;
            }
        }
    }
}