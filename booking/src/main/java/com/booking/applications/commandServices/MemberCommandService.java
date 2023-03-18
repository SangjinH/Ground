package com.booking.applications.commandServices;

import com.booking.domain.model.Member;
import com.booking.domain.model.commands.CreateMemberCommand;
import com.booking.domain.repository.MemberRepository;
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
