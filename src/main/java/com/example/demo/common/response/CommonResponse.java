package com.example.demo.common.response;

import static com.example.demo.common._enum.ResponseEnum.*;

import com.example.demo.common.model.EmptyListModel;
import com.example.demo.common.model.NoDataModel;
import com.example.demo.common.model.SuccessModel;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class CommonResponse {

    public ResponseEntity<?> success(Object body) {
        SuccessModel successModel = new SuccessModel<>(SUCCESS.getDescription(), OK.getDescription(), body);
        return ResponseEntity.status(200).body(successModel);
    }

    public ResponseEntity<?> noData() {
        NoDataModel noDataModel = new NoDataModel(SUCCESS.getDescription(), NO_DATA.getDescription());
        return ResponseEntity.status(200).body(noDataModel);
    }

    public ResponseEntity<?> emptyList(Object body) {
        EmptyListModel emptyListModel = new EmptyListModel<>(SUCCESS.getDescription(), NO_DATA.getDescription(), body);
        return ResponseEntity.status(200).body(emptyListModel);
    }
}
