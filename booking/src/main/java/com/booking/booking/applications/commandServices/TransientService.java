package com.booking.booking.applications.commandServices;

import com.booking.booking.applications.queryServices.MemberQueryService;
import com.booking.booking.domain.model.entity.Member;
import com.booking.booking.domain.model.valueobject.PreferAddress;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransientService {

    private final MemberQueryService memberQueryService;


    public Member transientService() {

        Member member = memberQueryService.getMember(1L);

        member.setPreferAddress(new PreferAddress("군포시", "고산로539번길"));

        log.info("member = {} ", member);

        return member;
    }
}
