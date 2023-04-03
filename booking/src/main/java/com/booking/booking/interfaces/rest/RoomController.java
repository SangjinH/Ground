package com.booking.booking.interfaces.rest;

import com.booking.booking.applications.commandServices.RoomCommandService;
import com.booking.booking.applications.queryServices.RoomQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.booking.booking.interfaces.constants.MeetingRoomApiUrl.MEETING_ROOM_ROOT_URL;

@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomQueryService roomQueryService;
    private final RoomCommandService roomCommandService;


    @PostMapping(MEETING_ROOM_ROOT_URL)
    public ResponseEntity<Object> createRoom() {
        roomCommandService.save();
        return ResponseEntity.ok().build();
    }
}
