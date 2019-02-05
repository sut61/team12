package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.LockerDuration;
import sut.se.team12.repository.LockerDurationRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LockerDurationController {
    @Autowired private LockerDurationRepository lockerDurationRepository;
    public LockerDurationController(LockerDurationRepository lockerDurationRepository){
        this.lockerDurationRepository = lockerDurationRepository;
    }

    @GetMapping("/lockerDuration")
    public Collection<LockerDuration> lockerDuration() {
        return lockerDurationRepository.findAll().stream().collect(Collectors.toList());
    }
}
