package org.example.pard.member.service;

import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.entity.Member;
import org.example.pard.member.repo.MemberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepo memberRepo;

    public void createMember(MemberCreateDTO dto) {
        memberRepo.save(new Member().toEntity(dto));
    }
    //memberDTO 생성 파라미터로 MemberCreateDTO 값을 받는다.(String name, String part, private int age)

    public MemberReadDTO findById(Long id) {
        return new MemberReadDTO().toDTO(memberRepo.findById(id).orElseThrow());
    }
    // 멤버 id값으로 member를 찾아서 출력함

    public List<MemberReadDTO> findAll() {
        return memberRepo.findAll()
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }// memberDTO에 있는 모든 멤버 값들을 리스트 형태로 출력함.

    public List<MemberReadDTO> findByPart(String part) {
        return memberRepo.findByPart(part)
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }// memberDTO에서 part를 통해서 맴버를 검색해 리스트형태로 출력

    public void deleteById(Long id) {
        memberRepo.deleteById(id);
    }
    // id로 member 삭제

}
