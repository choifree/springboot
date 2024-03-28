package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@Builder
public class ResponsePostDto {
    private long postId;
    private String title;
    private String content;
    private String useYn;
    private Date created;
    private Date modified;

}
