package app.controller;

import app.model.Member;
import app.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping({"/", ""})
    public String listMembers(Model model) {
        model.addAttribute("members", memberRepository.findAll());
        model.addAttribute("newMember", new Member());
        return "MembersList";
    }

    @PostMapping("/add")
    public String addMember(Member newMember) {
        memberRepository.save(newMember);
        return "redirect:/members/";
    }
}