package com.example.demo.repository.custom;

import com.example.demo.entity.PostEntity;

import java.util.List;

public interface PostCustomRepository {
    List<PostEntity> findUsingPost(String useYn);
}
