package com.example.demo.service;

import com.example.demo.dto.RequestPostDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.PostEntity;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public ResponseDto getPosts() {
        List<PostEntity> postList = postRepository.findAll();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("postList", postList.isEmpty() ? Collections.emptyList() : postList);
        ResponseDto dto = ResponseDto
                .builder()
                .successOrNot("Y")
                .data(hashMap)
                .build();
        return dto;
    }

    public ResponseDto getPostById(Long id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("post", postRepository.findById(id));
        ResponseDto dto = ResponseDto
                .builder()
                .successOrNot("Y")
                .data(hashMap)
                .build();
        return dto;
    }

    public ResponseDto writePost(RequestPostDto requestPostDto) {
        System.out.println("requestPostDto.getTitle()" + requestPostDto.getTitle());
        System.out.println("requestPostDto.getContent()" + requestPostDto.getContent());

        PostEntity entity = PostEntity.builder()
                .title(requestPostDto.getTitle())
                .content(requestPostDto.getContent())
                .created(new Date())
                .modified(new Date())
                .build();

        postRepository.save(entity);
        ResponseDto dto = ResponseDto
                .builder()
                .successOrNot("Y")
                .build();
        return dto;
    }
}
