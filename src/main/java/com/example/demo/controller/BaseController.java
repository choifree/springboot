package com.example.demo.controller;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class BaseController {
    protected MultiValueMap<String, ?> responseBody (Object data) {
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("successOrNot", "Y");
        multiValueMap.add("data", data);

        return multiValueMap;
    }
}
