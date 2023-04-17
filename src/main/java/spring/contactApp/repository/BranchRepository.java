package spring.contactApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.contactApp.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch,Integer> {
    boolean existsBranchByName(String name);
}
