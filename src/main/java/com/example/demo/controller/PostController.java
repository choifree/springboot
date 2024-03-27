package com.example.demo.controller;

import com.example.demo.dto.RequestPostDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.PostEntity;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/post")
public class PostController extends BaseController {

    private final PostService postService;

    @GetMapping("/getPosts")
    public ResponseEntity<?> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), null, HttpStatus.OK);
    }

    @GetMapping("/getPostById/{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.getPostById(id), null, HttpStatus.OK);
    }

    @PostMapping("/writePost")
    public ResponseEntity<?> writePost(@RequestBody RequestPostDto requestPostDto) {
        return new ResponseEntity<>(postService.writePost(requestPostDto), null, HttpStatus.OK);
    }

    @GetMapping("/health")
    public String health() {
        return "** health check post controller **";
    }
}
