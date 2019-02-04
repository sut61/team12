package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sut.se.team12.entity.TicketType;

@RepositoryRestResource
public interface TicketTypeRepository extends JpaRepository<TicketType,Long>{
    TicketType findByTicketTypeId(Long ticketTypeId);
    TicketType findByTicketType(String ticketType);
}
