package spring.contactApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.contactApp.entity.Role;
import spring.contactApp.entity.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role getRoleByRoleName(RoleName roleName);
}
