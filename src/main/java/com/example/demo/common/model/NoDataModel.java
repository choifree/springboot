package com.example.demo.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoDataModel {
    private String successOrNot;
    private String statusCode;

    public NoDataModel(String successOrNot, String statusCode) {
        this.successOrNot = successOrNot;
        this.statusCode = statusCode;
    }
}
