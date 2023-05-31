package com.booking.booking.domain.model.aggregate;

import com.booking.booking.domain.model.entity.Member;
import com.booking.booking.domain.model.entity.Room;
import com.booking.booking.domain.model.valueobject.BookingStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Booking extends AbstractAggregateRoot<Booking> {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member requester;
    @ManyToOne(fetch = FetchType.LAZY)
    private Room meetingRoom;

    private LocalDate bookingDate;

    private BookingStatus status;

    private LocalDateTime regDtm;

    public Booking(Member requester, Room meetingRoom, LocalDate bookingDate) {
        this.requester = requester;
        this.meetingRoom = meetingRoom;
        this.bookingDate = bookingDate;
        this.status = BookingStatus.WAITING;
        this.regDtm = LocalDateTime.now();

        this.requester.getBookingList().add(this);
        this.meetingRoom.getBookingList().add(this);

//        registerEvent(List.of(Member()));
    }
}
