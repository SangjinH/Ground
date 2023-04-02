package com.booking.booking.domain.model.aggregate;

import com.booking.booking.domain.model.entity.Member;
import com.booking.booking.domain.model.entity.Room;
import com.booking.booking.domain.model.valueobject.BookingStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
public class Booking {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member requester;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room meetingRoom;

    private LocalDate bookingDate;

    private BookingStatus bookingStatus;

    private LocalDateTime regDtm;
}
