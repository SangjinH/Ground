package com.booking.booking.domain.model.entity;

import com.booking.booking.domain.model.aggregate.Booking;
import com.booking.booking.domain.model.commands.CreateMemberCommand;
import com.booking.booking.domain.model.valueobject.PreferAddress;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @OneToMany(mappedBy = "requester", cascade = CascadeType.ALL)
    private List<Booking> bookingList = new ArrayList<>();

    private String name;
    private LocalDateTime regDtm;

    @Transient
    private PreferAddress preferAddress;

    public Member(CreateMemberCommand createMemberCommand) {
        this.name = createMemberCommand.getName();
        this.regDtm = LocalDateTime.now();
    }

    public void setPreferAddress(PreferAddress preferAddress) {
        this.preferAddress = preferAddress;
    }
}
