package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.FieldDuration;
import sut.se.team12.repository.FieldDurationRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FieldDurationController {
    @Autowired private FieldDurationRepository fieldDurationRepository;
    public FieldDurationController(FieldDurationRepository fieldDurationRepository){
        this.fieldDurationRepository = fieldDurationRepository;
    }

    @GetMapping("/fieldDuration")
    public Collection<FieldDuration> fieldDuration() {
        return fieldDurationRepository.findAll().stream().collect(Collectors.toList());
    }
}
