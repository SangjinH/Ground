package com.booking.booking.applications.commandServices;

import com.booking.booking.domain.model.entity.Room;
import com.booking.booking.domain.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.booking.booking.domain.model.entity.Room.*;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomCommandService {

    private final RoomRepository roomRepository;


    public Room save() {
        return roomRepository.save(createRoom());
    }
}
