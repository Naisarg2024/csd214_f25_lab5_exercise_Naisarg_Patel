package ca.saultcollege.lab5.repositories;

import ca.saultcollege.lab5.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookEntityRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByAuthorContainingIgnoreCase(String author);
}
