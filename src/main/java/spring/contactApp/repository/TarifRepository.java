package spring.contactApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.contactApp.entity.Tariff;

public interface TarifRepository extends JpaRepository<Tariff,Integer> {
    @Nat
}
