package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sut.se.team12.repository.*;
import sut.se.team12.entity.*;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class TicketController {
    @Autowired private TicketRepository ticketRepository;
    @Autowired private AdminRepository adminRepository;
    @Autowired private TicketTypeRepository ticketTypeRepository;
    @Autowired private FieldRepository fieldRepository;

    public TicketController(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/tickets")
    public Collection<Ticket> Ticket() {
        return ticketRepository.findAll().stream().collect(Collectors.toList());
    }
        
    
    @GetMapping("/tickets/last")
    public Ticket newTicket() {
        return ticketRepository.findByLastTickets();
    }

    @PostMapping("/tickets/sell/{type}/{name}/{phoneNumber}/{field}/{admin}")
    public Ticket newTicket(@RequestBody Ticket newTicket,
                            @PathVariable Long type,
                            @PathVariable String name,
                            @PathVariable String phoneNumber,
                            @PathVariable Long field,
                            @PathVariable Long admin                      
    ) 
{
        Admin adminTicket = adminRepository.findByAdminId(admin);
        Field fieldTicket = fieldRepository.findByFieldId(field);
        TicketType TiceketType = ticketTypeRepository.findByTicketTypeId(type);

        newTicket.setTicketType(TiceketType);
        newTicket.setName(name);
        newTicket.setPhoneNumber(phoneNumber);
        newTicket.setField(fieldTicket);
        newTicket.setDate(new Date());
        newTicket.setTime(LocalTime.now());
        newTicket.setAdmin(adminTicket);

        return ticketRepository.save(newTicket);
}
}