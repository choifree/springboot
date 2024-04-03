package com.example.demo.common._enum;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    // successOrNo
    SUCCESS("Y"),
    FAIL("N"),

    // statusCode
    OK("OK"),
    NO_DATA("NO_DATA");

    private final String description;

    ResponseEnum(String description) {this.description = description;}
}
