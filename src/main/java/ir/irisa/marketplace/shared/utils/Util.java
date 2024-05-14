package ir.irisa.marketplace.shared.utils;

import ir.irisa.marketplace.shared.model.BaseApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class Util {
    public ResponseEntity<BaseApiResponse> createResponse(Object object, HttpStatus httpStatus) {
        BaseApiResponse baseApiResponse = BaseApiResponse.builder()
                .action(true)
                .date(new Date())
                .message("")
                .result(object)
                .build();
        return new ResponseEntity<>(baseApiResponse, httpStatus);
    }
    public String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
