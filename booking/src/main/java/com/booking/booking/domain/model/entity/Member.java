package com.booking.booking.domain.model.entity;

import com.booking.booking.domain.model.commands.CreateMemberCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
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
