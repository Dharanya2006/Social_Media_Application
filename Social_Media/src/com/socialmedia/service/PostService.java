package com.socialmedia.service;

import com.socialmedia.model.*;
import com.socialmedia.util.IdGenerator;

import java.util.*;
public class PostService {
    public Post createPost(User user, String content) {
        Post post = new Post(IdGenerator.generatePostId(), user, content);
        user.getPosts().add(post);
        return post;
    }
    public List<Post> getFeed(User user) {
        List<Post> feed = new ArrayList<>();
        for (User friend : user.getFriends()) {
            feed.addAll(friend.getPosts());
        }
        feed.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));
        return feed;
    }
}