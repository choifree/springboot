package com.example.demo.dto.post;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class RequestPostDto {
    private String title;
    private String content;
    private Date created;
    private Date modified;
}
