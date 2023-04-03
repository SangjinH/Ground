package com.booking.booking.interfaces.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CreateBookingRqstDto {

    private String requesterId;
    private String meetingRoomId;
    private String requestDate;
}
