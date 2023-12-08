package com.booking.booking.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class CreateMemberCommand {

    @NotNull(message = "널이면 안된당께")
    private String name;
}
