package com.example.demo.repository.post.custom;

import com.example.demo.dto.post.RequestPostDto;
import com.example.demo.entity.post.PostEntity;

import java.util.List;

public interface PostCustomRepository {
    List<PostEntity> findUsingPost(String useYn);
}
