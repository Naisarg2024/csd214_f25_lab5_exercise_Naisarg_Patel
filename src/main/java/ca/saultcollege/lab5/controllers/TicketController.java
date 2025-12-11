package ca.saultcollege.lab5.controllers;

import ca.saultcollege.lab5.repositories.TicketEntityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketController {

    private final TicketEntityRepository ticketRepo;

    public TicketController(TicketEntityRepository ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @GetMapping("/tickets")
    public String listTickets(Model model) {
        model.addAttribute("tickets", ticketRepo.findAll());
        return "ticketList";
    }
}
