package ca.saultcollege.lab5.controllers;

import ca.saultcollege.lab5.repositories.MagazineEntityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MagazineController {

    private final MagazineEntityRepository magRepo;

    public MagazineController(MagazineEntityRepository magRepo) {
        this.magRepo = magRepo;
    }

    @GetMapping("/magazines")
    public String listMagazines(Model model) {
        model.addAttribute("magazines", magRepo.findAll());
        return "magazineList";
    }
}
