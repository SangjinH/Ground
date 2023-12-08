package com.booking.booking.domain.repository;

import com.booking.booking.domain.model.aggregate.Booking;
import com.booking.booking.domain.model.commands.CreateMemberCommand;
import com.booking.booking.domain.model.entity.Member;
import com.booking.booking.domain.model.entity.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;


@DataJpaTest
class BookingRepositoryTest {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    RoomRepository roomRepository;


    @Test
    @DisplayName("JPAtest")
    void JPAtest() throws Exception {
        // given
        Member han = new Member(CreateMemberCommand.builder()
                .name("han")
                .build());
        Member member = memberRepository.save(han);

        Room room = Room.createRoom();
        Room savedRoom = roomRepository.save(room);

        Booking booking = new Booking(member, savedRoom, LocalDate.now());
        Booking savedBooking = bookingRepository.save(booking);

        // when then
        Assertions.assertThat(savedBooking.getRequester().getName()).isEqualTo("han");
    }

}