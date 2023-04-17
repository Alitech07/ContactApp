package spring.contactApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.contactApp.entity.SimCard;

import java.util.UUID;

public interface SimCardRepository extends JpaRepository<SimCard, UUID> {
    boolean existsSimCardByNumber(Long number);
}
