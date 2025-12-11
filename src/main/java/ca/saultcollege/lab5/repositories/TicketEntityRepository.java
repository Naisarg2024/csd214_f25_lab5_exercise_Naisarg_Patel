package ca.saultcollege.lab5.repositories;

import ca.saultcollege.lab5.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketEntityRepository extends JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findByEventName(String eventName);
}
