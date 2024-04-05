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

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public List<ResponsePostDto> getPosts() {
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

        return postList;
    }

    public ResponsePostDto getPostById(Long id) {
        Optional<PostEntity> entity = postRepository.findById(id);
        ResponsePostDto responsePostDto = modelMapper.map(entity, ResponsePostDto.class);

        return responsePostDto;
    }

    @Transactional
    public ResponsePostIdDto writePost(RequestPostDto requestPostDto) {
        PostEntity entity = modelMapper.map(requestPostDto, PostEntity.class);
        PostEntity saveEntity = postRepository.save(entity);
        ResponsePostIdDto responsePostIdDto = ResponsePostIdDto.builder().postId(saveEntity.getPostId()).build();

        return responsePostIdDto;
    }

    @Transactional
    public ResponsePostIdDto updatePost(RequestPostDto requestPostDto) {
        PostEntity requestEntity = modelMapper.map(this.getPostById(requestPostDto.getPostId()), PostEntity.class);
        requestEntity.setTitle(requestEntity.getTitle());
        requestEntity.setContent(requestPostDto.getContent());
        requestEntity.setModified(new Date());
        requestEntity.setDeleted(new Date());

        ResponsePostIdDto responsePostIdDto = ResponsePostIdDto
                .builder()
                .postId(postRepository.save(requestEntity).getPostId())
                .build();

        return responsePostIdDto;
    }

    @Transactional
    public ResponsePostIdDto deletePost(RequestPostDto requestPostDto) {
        PostEntity requestEntity = modelMapper.map(this.getPostById(requestPostDto.getPostId()), PostEntity.class);
        requestEntity.setUseYn("N");
        requestEntity.setDeleted(new Date());

        ResponsePostIdDto responsePostIdDto = ResponsePostIdDto
                .builder()
                .postId(postRepository.save(requestEntity).getPostId())
                .build();

        return responsePostIdDto;
    }
}
