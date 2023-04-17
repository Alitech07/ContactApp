package spring.contactApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring.contactApp.entity.Packet;

@RepositoryRestResource
public interface PacketRepository extends JpaRepository<Packet,Integer> {
}
