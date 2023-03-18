package com.booking.domain.model;

import com.booking.domain.model.commands.CreateMemberCommand;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime regDtm;

    public Member(CreateMemberCommand createMemberCommand) {
        this.name = createMemberCommand.getName();
        this.regDtm = LocalDateTime.now();
    }
}
