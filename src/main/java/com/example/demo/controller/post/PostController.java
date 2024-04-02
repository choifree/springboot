package com.example.demo.controller.post;

import com.example.demo.dto.post.RequestPostDto;
import com.example.demo.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/getPosts")
    public ResponseEntity<?> getPosts() {
        return this.postService.getPosts();
    }

    @GetMapping("/getPostById/{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id") Long id) {
        return this.postService.getPostById(id);
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
