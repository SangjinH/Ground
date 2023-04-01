package com.booking.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URLEncoder;

import static com.booking.common.constants.Constants.RESULT_CODE;
import static com.booking.common.constants.Constants.RESULT_MESSAGE;

@Slf4j
@RestControllerAdvice // 전역 예외처리
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private HttpHeaders setHeaders(String responseCode, String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(RESULT_CODE, responseCode);
        headers.add(RESULT_MESSAGE, message);
        return headers;
    }

    @ExceptionHandler(value = {ApiException.class})
    protected ResponseEntity<Object> handleApiException(ApiException e) {
        String encodedResultMessage = URLEncoder.encode(e.getResultMessage());
        HttpHeaders headers = setHeaders(e.getResultCode(), encodedResultMessage);

        log.info("ApiException Code = {}, Message = {}, HttpStatus = {}",
                e.getResultCode(), e.getResultMessage(), e.getHttpStatus());

        return ResponseEntity
                .status(e.getHttpStatus())
                .headers(headers)
                .build();
    }
}
