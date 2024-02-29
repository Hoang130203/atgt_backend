package com.example.antoangiaothong.atgt.Service;

import com.example.antoangiaothong.atgt.Entity.Post;
import com.example.antoangiaothong.atgt.Entity.User;
import com.example.antoangiaothong.atgt.Entity.Video;
import com.example.antoangiaothong.atgt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public Collection<Video> getAllVideo(String userId) {
        User user= userRepository.getReferenceById(userId);
        if (user != null) {
            System.out.println(user.getName());
            return user.getVideos(); // Giả sử User có một phương thức getVideos() để lấy danh sách video
        } else {
            return null; // Trả về một danh sách rỗng nếu không tìm thấy user
        }
    }

    @Override
    public Collection<Post> getAllPost(String userId) {
        return userRepository.getReferenceById(userId).getPosts();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.getReferenceById(userId);
    }
}
