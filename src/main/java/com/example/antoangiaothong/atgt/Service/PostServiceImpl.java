package com.example.antoangiaothong.atgt.Service;

import com.example.antoangiaothong.atgt.Entity.Post;
import com.example.antoangiaothong.atgt.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post getPostById(int id) {
        Optional<Post> post=postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }else{
            return  null;
        }

    }
}
