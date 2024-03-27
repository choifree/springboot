package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class ResponseDto {

    private String successOrNot;
    private Object data;

}
