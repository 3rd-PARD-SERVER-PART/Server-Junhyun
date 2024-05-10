package org.example.pard.member.repo;

import org.example.pard.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepo extends JpaRepository<Member, Long> {
   List<Member> findByPart(String part);
   // MemberRepo에서 part를 통해서 Member를 찾음
}
