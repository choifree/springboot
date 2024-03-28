package com.example.demo.dto;

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
