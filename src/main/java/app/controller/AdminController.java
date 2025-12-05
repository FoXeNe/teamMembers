package app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin_dashboard";
    }

    @GetMapping("/admin/creategame")
    public String createGamePage() {
        return "create_game";
    }

    @GetMapping("/admin/createmember")
    public String createMemberPage() {
        return "create_member";
    }
}

