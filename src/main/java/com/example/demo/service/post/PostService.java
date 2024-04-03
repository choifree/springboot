package com.example.demo.service.post;

import com.example.demo.common.response.CommonResponse;
import com.example.demo.dto.post.RequestPostDto;
import com.example.demo.dto.post.ResponsePostDto;
import com.example.demo.dto.post.ResponsePostIdDto;
import com.example.demo.entity.post.PostEntity;
import com.example.demo.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public ResponseEntity<?> getPosts() {
        /**
         * to-be:
         * 페이징 관련 data 필요함
         * resultMap.put("paging", paging)
         *
         */
        List<ResponsePostDto> postList =
                postRepository.findUsingPost("Y")
                .stream()
                .map(data -> modelMapper.map(data, ResponsePostDto.class))
                .collect(Collectors.toList());

        if (postList.isEmpty()) {
            return new CommonResponse().emptyList(postList, "postList");
        } else {
            return new CommonResponse().success(postList, "postList");
        }
    }

    public ResponseEntity<?> getPostById(Long id) {
        Optional<PostEntity> entity = postRepository.findById(id);
        ResponsePostDto responsePostDto = modelMapper.map(entity, ResponsePostDto.class);

        if (responsePostDto == null) {
            return new CommonResponse().noData();
        } else {
            return new CommonResponse().success(responsePostDto, "post");
        }
    }

    @Transactional
    public ResponseEntity<?> writePost(RequestPostDto requestPostDto) {
        PostEntity entity = modelMapper.map(requestPostDto, PostEntity.class);
        PostEntity saveEntity = postRepository.save(entity);
        ResponsePostIdDto responsePostIdDto = ResponsePostIdDto.builder().postId(saveEntity.getPostId()).build();

        return new CommonResponse().success(responsePostIdDto, "postId");
    }
}
