package app.controller;

import app.model.Game;
import app.model.Member;
import app.repository.GameRepository;
import app.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminApiController {

    private final GameRepository gameRepository;
    private final MemberRepository memberRepository;

    public AdminApiController(GameRepository gameRepository, MemberRepository memberRepository) {
        this.gameRepository = gameRepository;
        this.memberRepository = memberRepository;
    }


    @PostMapping("/api/games")
    public String createGame(@RequestParam String name, RedirectAttributes redirectAttributes) {
        if (name == null || name.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Название игры не может быть пустым.");
            return "redirect:/admin/creategame";
        }

        Game game = new Game();
        game.setName(name.trim());
        gameRepository.save(game);

        redirectAttributes.addFlashAttribute("successMessage", String.format("Игра '%s' успешно создана (ID: %d).", game.getName(), game.getId()));

        return "redirect:/admin/creategame";
    }

    @PostMapping("/api/members")
    public String createMember(@RequestParam String name, RedirectAttributes redirectAttributes) {
        if (name == null || name.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Имя участника не может быть пустым.");
            return "redirect:/admin/createmember";
        }

        Member member = new Member();
        member.setName(name.trim());
        memberRepository.save(member);

        redirectAttributes.addFlashAttribute("successMessage", String.format("Игрок '%s' успешно создан (ID: %d).", member.getName(), member.getId()));

        return "redirect:/admin/createmember";
    }
}