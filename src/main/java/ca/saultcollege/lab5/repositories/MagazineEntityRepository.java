package ca.saultcollege.lab5.repositories;

import ca.saultcollege.lab5.entities.MagazineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MagazineEntityRepository extends JpaRepository<MagazineEntity, Long> {
    List<MagazineEntity> findByIssueNumber(int issueNumber);
}

