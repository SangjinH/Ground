package com.booking.booking.applications.commandServices;

import com.booking.booking.domain.model.entity.Member;
import com.booking.booking.domain.model.commands.CreateMemberCommand;
import com.booking.booking.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberCommandService {

    private final MemberRepository memberRepository;

    public Member join(CreateMemberCommand createMemberCommand) {
        return memberRepository.save(new Member(createMemberCommand));
    }
}
