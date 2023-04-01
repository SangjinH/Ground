package com.booking.common.constants;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {

    SUCCESS("0000", "정상응답", HttpStatus.OK),


    MEMBER_NOT_EXIST("1000", "조회된 사용자가 없습니다.", HttpStatus.BAD_REQUEST),
    ;

    private final String responseCode;
    private final String responseMessage;
    private final HttpStatus status;

    ResponseCode(String responseCode, String responseMessage, HttpStatus status) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.status = status;
    }
}
