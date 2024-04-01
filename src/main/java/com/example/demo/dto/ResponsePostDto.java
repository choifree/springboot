package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ResponsePostDto {
    private long postId;
    private String title;
    private String content;
    private String useYn;
    private Date created;
    private Date modified;

}
