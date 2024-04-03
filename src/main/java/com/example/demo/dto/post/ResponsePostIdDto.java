package com.example.demo.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePostIdDto {
    private long postId;

    @Builder
    public ResponsePostIdDto(long postId) {
        this.postId = postId;
    }
}
