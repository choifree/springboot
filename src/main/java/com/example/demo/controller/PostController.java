package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @GetMapping("/getPosts")
    public ResponseEntity<?> getPosts() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/health")
    public String health() {
        return "** health check post controller **";
    }
}
