package com.booking.interfaces.rest;

import com.booking.applications.commandServices.MemberCommandService;
import com.booking.domain.model.Member;
import com.booking.interfaces.rest.dto.CreateMemberRqstDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.booking.interfaces.constants.MemberApiUrl.MEMBER_ROOT_URL;

@RequestMapping(value = MEMBER_ROOT_URL)
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;


    @PostMapping
    public Member join(@RequestBody CreateMemberRqstDto rqstDto) {
        Member member = memberCommandService.join(rqstDto.toCommand());
        System.out.println("createMember = " + member);
        return member;
    }
}
