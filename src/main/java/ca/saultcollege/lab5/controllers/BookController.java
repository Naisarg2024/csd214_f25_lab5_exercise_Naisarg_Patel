package ca.saultcollege.lab5.controllers;

import ca.saultcollege.lab5.entities.BookEntity;
import ca.saultcollege.lab5.repositories.BookEntityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookEntityRepository bookRepo;

    public BookController(BookEntityRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    // LIST ALL BOOKS
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "bookList";
    }

    // ADD FORM (CREATE)
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new BookEntity());
        return "bookForm";
    }

    // EDIT FORM (UPDATE)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        BookEntity book = bookRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + id));

        model.addAttribute("book", book);
        return "bookForm";
    }

    // SAVE HANDLER (CREATE + UPDATE)
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") BookEntity book) {
        bookRepo.save(book);
        return "redirect:/books";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepo.deleteById(id);
        return "redirect:/books";
    }

    // SEARCH
    @GetMapping("/books/search")
    public String searchBooks(@RequestParam("author") String author, Model model) {

        List<BookEntity> results = bookRepo.findByAuthorContainingIgnoreCase(author);

        model.addAttribute("books", results);
        model.addAttribute("searchTerm", author);

        return "bookList";
    }
}
