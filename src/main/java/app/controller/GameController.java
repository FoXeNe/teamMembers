package app.controller;

import app.model.Game;
import app.repository.GameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/games")
public class GameController {
    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping({"/", ""})
    public String listMembers(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        model.addAttribute("newGame", new Game());
        return "GamesList";
    }

    @PostMapping("/add")
    public String addMember(Game newGame) {
        gameRepository.save(newGame);
        return "redirect:/games/";
    }
}