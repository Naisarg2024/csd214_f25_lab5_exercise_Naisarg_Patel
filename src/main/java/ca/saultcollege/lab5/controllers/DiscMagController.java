package ca.saultcollege.lab5.controllers;

import ca.saultcollege.lab5.repositories.DiscMagEntityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiscMagController {

    private final DiscMagEntityRepository discRepo;

    public DiscMagController(DiscMagEntityRepository discRepo) {
        this.discRepo = discRepo;
    }

    @GetMapping("/discmags")
    public String listDiscMags(Model model) {
        model.addAttribute("discmags", discRepo.findAll());
        return "discMagList";
    }
}
