package com.booking.booking.applications.queryServices;

import com.booking.booking.domain.repository.MemberRepository;
import com.booking.booking.domain.model.entity.Member;
import com.booking.common.constants.ResponseCode;
import com.booking.common.exception.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryService {

    private final MemberRepository memberRepository;


    public List<Member> getMemberList() {
        return memberRepository.findAll();
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ApiException(ResponseCode.MEMBER_NOT_EXIST));
    }

}
