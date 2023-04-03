package com.booking.booking.interfaces.rest;

import com.booking.booking.applications.commandServices.BookingCommandService;
import com.booking.booking.applications.queryServices.BookingQueryService;
import com.booking.booking.domain.model.commands.CreateBookingCommand;
import com.booking.booking.interfaces.rest.dto.CreateBookingRqstDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static com.booking.booking.interfaces.constants.BookingApiUrl.BOOKING_ROOT_URL;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingCommandService bookingCommandService;
    private final BookingQueryService bookingQueryService;


    @PostMapping(BOOKING_ROOT_URL)
    public ResponseEntity<Object> createRequestBooking(@RequestBody CreateBookingRqstDto rqstDto) {

        bookingCommandService.requestBooking(CreateBookingCommand.builder()
                .memberId(Long.valueOf(rqstDto.getRequesterId()))
                .roomId(Long.valueOf(rqstDto.getMeetingRoomId()))
                .requestDate(LocalDate.parse(rqstDto.getRequestDate()))
                .build());

        return ResponseEntity.ok().build();
    }

    @GetMapping(BOOKING_ROOT_URL)
    public ResponseEntity<Object> getBookingList() {
        return ResponseEntity.ok(bookingQueryService.getBookingList());
    }
}
