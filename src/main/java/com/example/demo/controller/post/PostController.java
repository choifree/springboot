package com.example.demo.controller.post;

import com.example.demo.common.response.CommonResponse;
import com.example.demo.dto.post.RequestPostDto;
import com.example.demo.dto.post.ResponsePostDto;
import com.example.demo.dto.post.ResponsePostIdDto;
import com.example.demo.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
        List<ResponsePostDto> postList = this.postService.getPosts();
        HashMap<String, List<ResponsePostDto>> resultMap = new HashMap<>();
        resultMap.put("postList", postList);
        if (postList.isEmpty()) {
            return new CommonResponse().emptyList(resultMap);
        } else {
            return new CommonResponse().success(resultMap);
        }
    }

    /**
     * 특정 게시글 조회
     * @param id
     */
    @GetMapping("/getPostById/{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id") Long id) {
        ResponsePostDto post = this.postService.getPostById(id);
        if (post == null) {
            return new CommonResponse().noData();
        } else {
            HashMap<String, ResponsePostDto> resultMap = new HashMap<>();
            resultMap.put("post", post);
            return new CommonResponse().success(resultMap);
        }
    }

    /**
     * 게시글 작성
     * @param requestPostDto
     */
    @PostMapping("/writePost")
    public ResponseEntity<?> writePost(@RequestBody RequestPostDto requestPostDto) {
        ResponsePostIdDto postId = this.postService.writePost(requestPostDto);
        return new CommonResponse().success(postId);
    }

    /**
     * 게시글 수정
     * @param requestPostDto
     */
    @PostMapping("/updatePost")
    public ResponseEntity<?> updatePost(@RequestBody RequestPostDto requestPostDto) {
        ResponsePostIdDto postId = this.postService.updatePost(requestPostDto);
        return new CommonResponse().success(postId);
    }

    /**
     * 게시글 삭제
     * @param requestPostDto
     */
    @PostMapping("/deletePost")
    public ResponseEntity<?> deletePost(@RequestBody RequestPostDto requestPostDto) {
        ResponsePostIdDto postId = this.postService.deletePost(requestPostDto);
        return new CommonResponse().success(postId);
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
