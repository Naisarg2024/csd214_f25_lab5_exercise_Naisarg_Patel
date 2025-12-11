package ca.saultcollege.lab5.repositories;

import ca.saultcollege.lab5.entities.DiscMagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscMagEntityRepository extends JpaRepository<DiscMagEntity, Long> {
    List<DiscMagEntity> findByDiscType(String discType);
}
