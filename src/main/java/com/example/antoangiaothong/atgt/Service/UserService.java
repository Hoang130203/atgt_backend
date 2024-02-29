package com.example.antoangiaothong.atgt.Service;

import com.example.antoangiaothong.atgt.Entity.Post;
import com.example.antoangiaothong.atgt.Entity.User;
import com.example.antoangiaothong.atgt.Entity.Video;

import java.util.Collection;

public interface UserService {
    Collection<Video> getAllVideo(String userId);
    Collection<Post> getAllPost(String userId);
    User getUser(String userId);
}
