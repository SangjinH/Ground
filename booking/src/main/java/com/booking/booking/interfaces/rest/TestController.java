package com.booking.booking.interfaces.rest;

import com.booking.booking.applications.commandServices.TransientService;
import com.booking.booking.domain.model.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TransientService transientService;

    @GetMapping("/transient-test")
    public void transientTest() {

        Member member = transientService.transientService();

        log.info("Controller Member = {}", member);
    }
}
