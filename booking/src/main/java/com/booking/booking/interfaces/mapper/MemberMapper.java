package com.booking.booking.interfaces.mapper;

import com.booking.booking.domain.model.entity.Member;
import com.booking.booking.interfaces.rest.dto.MemberResponseDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapStructConfig.class)
public abstract class MemberMapper {


    @Mapping(target = "name", source = "member.name")
    @Mapping(target = "regDtm", source = "member.regDtm")
    @Mapping(target = "preferCity", ignore = true)
    @Mapping(target = "preferRoad", ignore = true)
    public abstract MemberResponseDto toResponseDto(Member member);

    @AfterMapping
    protected void afterMapping(
            @MappingTarget final MemberResponseDto.MemberResponseDtoBuilder targetBuilder,
            Member member) {

        targetBuilder.preferCity(member.getPreferAddress().getCity());
        targetBuilder.preferRoad(member.getPreferAddress().getRoad());
    }
}
