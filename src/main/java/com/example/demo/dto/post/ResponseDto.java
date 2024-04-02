package com.example.demo.dto.post;

import lombok.*;

@Getter
@Setter
public class ResponseDto<T> {

    private String successOrNot;
    private T data;

    public ResponseDto (T data) {
        this.data = data;
    }

}
