package com.example.demo.service;

import com.example.demo.dto.RequestPostDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.ResponsePostDto;
import com.example.demo.dto.ResultDto;
import com.example.demo.entity.PostEntity;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public ResultDto getPosts() {
        List<ResponsePostDto> postList = postRepository.findUsingPost("Y")
                                                            .stream()
                                                            .map(PostEntity::toResponsePostDto)
                                                            .collect(Collectors.toList());

        ResultDto result = ResultDto
                                .builder()
                                .postList(postList)
                                .successOrNot("Y")
                                .build();

        return result;
    }

    public ResponseDto getPostById(Long id) {
        HashMap<String, Optional<PostEntity>> resultMap = new HashMap<>();
        resultMap.put("post", postRepository.findById(id));

        return new ResponseDto(resultMap);

    }

    @Transactional
    public ResponseDto writePost(RequestPostDto requestPostDto) {

        PostEntity entity = PostEntity.builder()
                .title(requestPostDto.getTitle())
                .content(requestPostDto.getContent())
                .created(new Date())
                .modified(new Date())
                .build();

        postRepository.save(entity);
        return new ResponseDto<>("null");
    }
}
