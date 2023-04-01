package com.booking.booking.domain.repository;


import com.booking.booking.domain.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
