package spring.contactApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.contactApp.entity.Address;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
