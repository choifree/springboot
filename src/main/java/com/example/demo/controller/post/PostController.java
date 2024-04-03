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


    /**
     * 전체 게시글 조회
     */
    @GetMapping("/getPosts")
    public ResponseEntity<?> getPosts() {
        return this.postService.getPosts();
    }

    /**
     * 특정 게시글 조회
     * @param id
     */
    @GetMapping("/getPostById/{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id") Long id) {
        return this.postService.getPostById(id);
    }

    /**
     * 게시글 작성
     * @param requestPostDto
     */
    @PostMapping("/writePost")
    public ResponseEntity<?> writePost(@RequestBody RequestPostDto requestPostDto) {
        return this.postService.writePost(requestPostDto);
    }


    /**
     * health check api
     *
     */
    @GetMapping("/health")
    public String health() {
        return "** health check post controller **";
    }
}
