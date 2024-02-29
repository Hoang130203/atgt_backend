package com.example.antoangiaothong.atgt.Service;

import com.example.antoangiaothong.atgt.Entity.User;
import com.example.antoangiaothong.atgt.Repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService{
    private final VideoRepository videoRepository;
    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository){
        this.videoRepository=videoRepository;
    }
    @Override
    public User getOwner(int id) {
        return videoRepository.getReferenceById(id).getOwner();
    }
}
