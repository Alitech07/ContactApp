package spring.contactApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring.contactApp.entity.USSD;

@RepositoryRestResource(path = "ussd")
public interface USSDRepository extends JpaRepository<USSD,Integer> {
}
