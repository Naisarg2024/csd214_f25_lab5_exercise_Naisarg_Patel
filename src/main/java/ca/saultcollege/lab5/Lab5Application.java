package ca.saultcollege.lab5;

import ca.saultcollege.lab5.entities.BookEntity;
import ca.saultcollege.lab5.entities.DiscMagEntity;
import ca.saultcollege.lab5.entities.MagazineEntity;
import ca.saultcollege.lab5.entities.TicketEntity;
import ca.saultcollege.lab5.repositories.BookEntityRepository;
import ca.saultcollege.lab5.repositories.DiscMagEntityRepository;
import ca.saultcollege.lab5.repositories.MagazineEntityRepository;
import ca.saultcollege.lab5.repositories.TicketEntityRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Lab5Application implements CommandLineRunner {

    private final BookEntityRepository bookRepo;
    private final MagazineEntityRepository magRepo;
    private final DiscMagEntityRepository discMagRepo;
    private final TicketEntityRepository ticketRepo;

    // Constructor Injection all repositories
    public Lab5Application(BookEntityRepository bookRepo,
                           MagazineEntityRepository magRepo,
                           DiscMagEntityRepository discMagRepo,
                           TicketEntityRepository ticketRepo) {
        this.bookRepo = bookRepo;
        this.magRepo = magRepo;
        this.discMagRepo = discMagRepo;
        this.ticketRepo = ticketRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab5Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        System.out.println("\n----- Preloading Database with Faker Data (Lab 5) -----\n");

        // BOOKS
        for (int i = 0; i < 10; i++) {
            BookEntity b = new BookEntity(
                    faker.book().title(),
                    faker.number().randomDouble(2, 5, 50),
                    faker.book().publisher(),
                    faker.book().author(),
                    faker.book().genre()
            );
            bookRepo.save(b);
        }
        System.out.println("Inserted 10 Books.");

        // MAGAZINES
        for (int i = 0; i < 10; i++) {
            MagazineEntity m = new MagazineEntity(
                    faker.book().title(),
                    faker.number().randomDouble(2, 3, 40),
                    faker.book().publisher(),
                    faker.number().numberBetween(1, 100)
            );
            magRepo.save(m);
        }
        System.out.println("Inserted 10 Magazines.");

        // DISC MAGAZINES
        for (int i = 0; i < 10; i++) {
            DiscMagEntity dm = new DiscMagEntity(
                    faker.book().title(),
                    faker.number().randomDouble(2, 5, 60),
                    faker.book().publisher(),
                    faker.number().numberBetween(1, 100),
                    faker.options().option("DVD", "BluRay")
            );
            discMagRepo.save(dm);
        }
        System.out.println("Inserted 10 DiscMag items.");

        // TICKETS
        for (int i = 0; i < 10; i++) {
            TicketEntity t = new TicketEntity(
                    faker.commerce().productName(),
                    faker.number().randomDouble(2, 20, 150),
                    faker.book().title(),
                    faker.address().city()
            );
            ticketRepo.save(t);
        }
        System.out.println("Inserted 10 Tickets.");

        System.out.println("\n----- DONE PRELOADING DATABASE -----\n");
    }
}
