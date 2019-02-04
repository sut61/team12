package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.*;
import sut.se.team12.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TrainingTypeController {

    @Autowired private TrainingTypeRepository trainingTypeRepository;

    public TrainingTypeController(TrainingTypeRepository trainingTypeRepository){
        this.trainingTypeRepository = trainingTypeRepository;
    }
    @GetMapping("/training/type")
    public Collection<TrainingType> TrainingType() {
        return trainingTypeRepository.findAll().stream().collect(Collectors.toList());
    }
}