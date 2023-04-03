package com.booking.booking.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookingCommand {

    private Long memberId;
    private Long roomId;
    private LocalDate requestDate;
}
