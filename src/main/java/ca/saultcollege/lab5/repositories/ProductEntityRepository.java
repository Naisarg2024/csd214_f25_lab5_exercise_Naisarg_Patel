package ca.saultcollege.lab5.repositories;

import ca.saultcollege.lab5.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
// This custom query specifically fetches ONLY the entities of type Book.
//    // It's the most efficient and direct way to get all books.
//    @Query("SELECT b FROM BookEntity b")
}