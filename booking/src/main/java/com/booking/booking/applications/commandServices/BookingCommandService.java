package com.booking.booking.applications.commandServices;

import com.booking.booking.domain.model.entity.Member;
import com.booking.booking.domain.model.entity.Room;
import com.booking.booking.domain.repository.BookingRepository;
import com.booking.booking.domain.repository.MemberRepository;
import com.booking.booking.domain.repository.RoomRepository;
import com.booking.common.constants.ResponseCode;
import com.booking.common.exception.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class BookingCommandService {

    private final BookingRepository bookingRepository;
    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;

    public void requestBooking(Long memberId, Long roomId, LocalDate requestDate) {

        Member requester = getRequesterOrElseThrow(memberId);
        Room meetingRoom = getMeetingRoomOrElseThrow(roomId);

        meetingRoom.canBookOnRequestDate(requestDate);


    }






    // ====================== 내부메서드 =====================
    private Member getRequesterOrElseThrow(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new ApiException(ResponseCode.MEMBER_NOT_EXIST));
    }

    private Room getMeetingRoomOrElseThrow(Long roomId) {
        return roomRepository.findById(roomId).orElseThrow(() -> new ApiException(ResponseCode.ROOM_NOT_EXIST));
    }
}
