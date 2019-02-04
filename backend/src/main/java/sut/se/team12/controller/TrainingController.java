package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.*;
import sut.se.team12.repository.*;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TrainingController {

    @Autowired private TrainingRepository trainingRepository;
    @Autowired private TrainingTypeRepository trainingTypeRepository;
    @Autowired private TrainingProgramRepository trainingProgramRepository;
    @Autowired private AdminRepository adminRepository;

    public TrainingController(TrainingRepository trainingRepository){
        this.trainingRepository = trainingRepository;
    }
    @GetMapping("/training")
    public Collection<Training> Training() {
        return trainingRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/training/create/{admin}/{title}/{description}/{dateFrom}/{dateTo}/{type}/{program}/{instructor}/{location}/{enrollment}/{cost}")
    public Training training(  
        @PathVariable Long admin, 
        @PathVariable String title,
        @PathVariable String description,
        @PathVariable Date dateFrom,
        @PathVariable Date dateTo,
        @PathVariable Long type,
        @PathVariable Long program,
        @PathVariable String instructor,
        @PathVariable String location,
        @PathVariable int enrollment,
        @PathVariable Long cost) throws ParseException {

            Training newTraining = new Training();

            Admin _admin = adminRepository.findByAdminId(admin);
            TrainingType _type = trainingTypeRepository.findByTypeId(type);
            TrainingProgram _program = trainingProgramRepository.findByProgramId(program);

            newTraining.setAdmin(_admin);
            newTraining.setTitle(title);
            newTraining.setDescription(description);
            newTraining.setDateFrom(dateFrom);
            newTraining.setDateTo(dateTo);
            newTraining.setTrainingType(_type);
            newTraining.setTrainingProgram(_program);
            newTraining.setInstructor(instructor);
            newTraining.setLocation(location);
            newTraining.setEnrollment(enrollment);
            newTraining.setCost(cost);

        return trainingRepository.save(newTraining);
    }
}