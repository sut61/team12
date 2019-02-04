package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.*;
import sut.se.team12.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TrainingProgramController {

    @Autowired private TrainingProgramRepository trainingProgramRepository;

    public TrainingProgramController(TrainingProgramRepository trainingProgramRepository){
        this.trainingProgramRepository = trainingProgramRepository;
    }
    @GetMapping("/training/program")
    public Collection<TrainingProgram> TrainingProgram() {
        return trainingProgramRepository.findAll().stream().collect(Collectors.toList());
    }
}