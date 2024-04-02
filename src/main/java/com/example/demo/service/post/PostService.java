package com.example.demo.service.post;

import com.example.demo.common.response.CommonResponse;
import com.example.demo.dto.post.RequestPostDto;
import com.example.demo.dto.post.ResponseDto;
import com.example.demo.dto.post.ResponsePostDto;
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
        List<ResponsePostDto> postList =
                postRepository.findUsingPost("Y")
                .stream()
                .map(data -> modelMapper.map(data, ResponsePostDto.class))
                .collect(Collectors.toList());

        if (postList == null) Collections.<ResponsePostDto>emptyList();

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("postList", postList);

        /**
         * to-be:
         * 페이징 관련 data 필요함
         * resultMap.put("paging", paging)
         *
         */

        return new CommonResponse().success(resultMap);
    }

    public ResponseEntity<?> getPostById(Long id) {
        Optional<PostEntity> entity = postRepository.findById(id);
        ResponsePostDto responsePostDto = modelMapper.map(entity, ResponsePostDto.class);

        HashMap<String, Object> resultMap = new HashMap<>();

        if (responsePostDto == null) {
            return new CommonResponse().noData();
        } else {
            resultMap.put("post", responsePostDto);
            return new CommonResponse().success(resultMap);
        }
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
