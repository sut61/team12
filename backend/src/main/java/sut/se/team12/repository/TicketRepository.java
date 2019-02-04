package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.CrossOrigin;

import sut.se.team12.entity.Ticket;

@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
public interface TicketRepository extends JpaRepository<Ticket,Long>{
    Ticket findByTicketId(Long ticketId);
    @Query(value = "SELECT * FROM    TB_TICKET WHERE   TICKET_ID = (SELECT MAX(TICKET_ID)  FROM TB_TICKET)", nativeQuery = true)
    Ticket findByLastTickets();
}
