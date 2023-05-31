package com.booking.booking.interfaces.rest;

import com.booking.booking.applications.commandServices.TransientService;
import com.booking.booking.domain.model.entity.Member;
import com.booking.booking.interfaces.mapper.MemberMapper;
import com.booking.booking.interfaces.rest.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TransientService transientService;
    private final MemberMapper memberMapper;

    @GetMapping("/transient-test")
    public ResponseEntity<Object> transientTest() {

        Member member = transientService.transientService();
        MemberResponseDto memberResponseDto = memberMapper.toResponseDto(member);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }
}
