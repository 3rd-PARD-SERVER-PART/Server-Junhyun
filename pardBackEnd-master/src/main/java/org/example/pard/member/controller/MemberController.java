package org.example.pard.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.service.MemberService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pard")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public String createMember(@RequestBody MemberCreateDTO dto) {
        memberService.createMember(dto);
        return "파드에 가입을 축하드립니다.";
    }

    @GetMapping("")
    public List<MemberReadDTO> findMember(@RequestParam(required = false) String part) {
        //RequestParam으로 값을 받는데 required를 false로 바꿔서(원래는 true)
        //값이 없을 때 에러가 나지 않고 findAll을 통해 GetMapping을 할 수 있게 함
        if (StringUtils.hasText(part)) { //만약 part로 입력받은 값이 있으면
            // findByPart로 파트를 통해서 member를 찾고
            // 만약 part로 넣은값에 table에 존재하지 않는 데이터일때도 넘어가짐
            return memberService.findByPart(part);
        }
        // 그렇지 않으면 그냥 전체를 find해서 리턴한다.
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public MemberReadDTO findById(@PathVariable Long id) {
        return memberService.findById(id);
    }
    //PathVariable로 id를 받아서 find하고 리턴해준다.
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
        return "삭제됨";
    }
    // id를 받아 해당 member를 삭제
}
