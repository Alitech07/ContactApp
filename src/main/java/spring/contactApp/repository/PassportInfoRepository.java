package spring.contactApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring.contactApp.entity.PassportInfo;

import java.util.UUID;

@RepositoryRestResource(path = "passportinfo")
public interface PassportInfoRepository extends JpaRepository<PassportInfo, UUID> {
}
