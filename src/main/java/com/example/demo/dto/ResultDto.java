package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ResultDto<T> {
    private String successOrNot;
    private List<ResponsePostDto> postList;

}
