package com.example.demo.common.response;

import com.example.demo.common.model.NoDataModel;
import com.example.demo.common.model.SuccessModel;
import org.springframework.http.ResponseEntity;

public class CommonResponse {
    public ResponseEntity<?> success(Object body) {
        SuccessModel successModel = new SuccessModel<>("Y", "OK", body);
        return ResponseEntity.status(200).body(successModel);
    }

    public ResponseEntity<?> noData() {
        NoDataModel noDataModel = new NoDataModel("N", "NO_DATA");
        return ResponseEntity.status(200).body(noDataModel);
    }
}
