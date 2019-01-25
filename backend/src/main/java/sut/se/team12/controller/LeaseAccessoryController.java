package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.LeaseAccessory;
import sut.se.team12.repository.LeaseAccessoryRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LeaseAccessoryController {
    @Autowired private LeaseAccessoryRepository leaseAccessoryRepository;
    public LeaseAccessoryController(LeaseAccessoryRepository leaseAccessoryRepository){
        this.leaseAccessoryRepository = leaseAccessoryRepository;
    }

    @GetMapping("/accessory")
    public Collection<LeaseAccessory> leaseaccessory() {
        return leaseAccessoryRepository.findAll().stream().collect(Collectors.toList());
    }
}
