package com.example.antoangiaothong.atgt.Controller;

import com.example.antoangiaothong.atgt.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable int id){
        return ResponseEntity.ok(postService.getPostById(id)) ;
    }
}
