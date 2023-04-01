package com.booking.booking.interfaces.rest.dto;

import com.booking.booking.domain.model.commands.CreateMemberCommand;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateMemberRqstDto {

    @NotNull
    private String name;

    public CreateMemberCommand toCommand() {
        return CreateMemberCommand.builder()
                .name(name)
                .build();
    }
}
