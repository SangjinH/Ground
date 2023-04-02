package com.booking.booking.domain.model.entity;

import com.booking.booking.domain.model.aggregate.Booking;
import com.booking.booking.domain.model.commands.CreateMemberCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "requester", cascade = CascadeType.ALL)
    private List<Booking> bookingList = new ArrayList<>();

    private String name;

    private LocalDateTime regDtm;

    public Member(CreateMemberCommand createMemberCommand) {
        this.name = createMemberCommand.getName();
        this.regDtm = LocalDateTime.now();
    }
}
