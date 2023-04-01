package com.booking.common.exception;


import com.booking.common.constants.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiException extends RuntimeException {

    private final String resultCode;
    private final String resultMessage;
    private final HttpStatus httpStatus;

    public ApiException(ResponseCode responseCode) {
        super("[" + responseCode.getResponseCode() + "] " + responseCode.getResponseMessage());
        this.resultCode = responseCode.getResponseCode();
        this.resultMessage = responseCode.getResponseMessage();
        this.httpStatus = responseCode.getStatus();
    }
}
