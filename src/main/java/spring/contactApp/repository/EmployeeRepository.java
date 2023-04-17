package spring.contactApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.contactApp.entity.Employee;

import javax.validation.constraints.Email;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> getEmployeeByEmail(@Email String email);
}
