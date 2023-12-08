package com.booking.booking.interfaces.rest;

import com.booking.booking.applications.commandServices.MemberCommandService;
import com.booking.booking.applications.queryServices.MemberQueryService;
import com.booking.booking.domain.model.entity.Member;
import com.booking.booking.interfaces.rest.dto.CreateMemberRqstDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.booking.booking.interfaces.constants.MemberApiUrl.GET_MEMBER_BY_ID;
import static com.booking.booking.interfaces.constants.MemberApiUrl.MEMBER_ROOT_URL;

@RestController
@RequiredArgsConstructor
@Validated
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;


    @PostMapping(MEMBER_ROOT_URL)
    public Member join(@RequestBody @Valid CreateMemberRqstDto rqstDto) {
        return memberCommandService.join(rqstDto.toCommand());
    }

    @GetMapping(MEMBER_ROOT_URL)
    public List<Member> getMemberList() {
        return memberQueryService.getMemberList();
    }

    @GetMapping(GET_MEMBER_BY_ID)
    public Member getMemberById(@PathVariable("id") Long id) {
        return memberQueryService.getMember(id);
    }
}
