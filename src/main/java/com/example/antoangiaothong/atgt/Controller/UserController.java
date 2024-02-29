package com.example.antoangiaothong.atgt.Controller;

import com.example.antoangiaothong.atgt.Entity.Post;
import com.example.antoangiaothong.atgt.Entity.User;
import com.example.antoangiaothong.atgt.Entity.Video;
import com.example.antoangiaothong.atgt.Service.UserService;
import com.example.antoangiaothong.atgt.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final VideoService videoService;
    @Autowired
    public UserController(UserService userService,VideoService videoService){
        this.userService=userService;
        this.videoService=videoService;
    }
    @GetMapping("/video")
    @ResponseBody
    public Collection<Video> getVideo(){
        Video video=new Video();
        return userService.getAllVideo("12");
    }
    @GetMapping("/name")
    public ResponseEntity<String> getName() {
        String userName = userService.getUser("1234").getName();
        return ResponseEntity.status(HttpStatus.OK).body(userName);
    }
    @GetMapping("/owner")
    public User getOwner(){
        return videoService.getOwner(1);
    }

    @GetMapping("/posts/{id}")
    public Collection<Post> getPosts(@PathVariable String  id){
        return userService.getAllPost(id);
    }
}
