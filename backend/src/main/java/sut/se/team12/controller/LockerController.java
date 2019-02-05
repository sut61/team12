package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.Locker;
import sut.se.team12.repository.LockerRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LockerController {
    @Autowired private LockerRepository lockerRepository;
    public LockerController(LockerRepository lockerRepository){
        this.lockerRepository = lockerRepository;
    }

    @GetMapping("/locker")
    public Collection<Locker> Locker() {
        return lockerRepository.findAll().stream().collect(Collectors.toList());
    }
}
