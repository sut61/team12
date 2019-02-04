package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sut.se.team12.entity.TicketType;
import sut.se.team12.repository.TicketTypeRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TicketTypeController {
    @Autowired private TicketTypeRepository ticketTypeRepository;
    public TicketTypeController(TicketTypeRepository ticketTypeRepository){
        this.ticketTypeRepository = ticketTypeRepository;
    }
    @GetMapping("/ticketTypes")
    public Collection<TicketType> TicketTypes() {
        return ticketTypeRepository.findAll().stream().collect(Collectors.toList());
    }
}
