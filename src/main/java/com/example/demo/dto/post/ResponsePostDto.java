package com.example.demo.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePostDto {
    private long postId;
    private String title;
    private String content;
    private String useYn;
    private Date created;
    private Date modified;

}
