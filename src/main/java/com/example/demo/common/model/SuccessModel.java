package com.example.demo.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessModel<T> {
    private String successOrNot;
    private String statusCode;
    private T data;

    public SuccessModel(String successOrNot, String statusCode, T data) {
        this.successOrNot = successOrNot;
        this.statusCode = statusCode;
        this.data = data;
    }
}
