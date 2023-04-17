package spring.contactApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.contactApp.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    boolean existsByName(String name);
}
