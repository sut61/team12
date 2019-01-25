package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.LeaseDuration;
import sut.se.team12.repository.LeaseDurationRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LeaseDurationController {
    @Autowired private LeaseDurationRepository leasedurationRepository;
    public LeaseDurationController(LeaseDurationRepository leasedurationRepository){
        this.leasedurationRepository = leasedurationRepository;
    }

    @GetMapping("/duration")
    public Collection<LeaseDuration> LeaseDurations() {
        return leasedurationRepository.findAll().stream().collect(Collectors.toList());
    }
}
