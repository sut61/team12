package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.Degree;
import sut.se.team12.repository.DegreeRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DegreeController {
    @Autowired private DegreeRepository degreeRepository;
    public DegreeController(DegreeRepository degreeRepository){
        this.degreeRepository = degreeRepository;
    }

    @GetMapping("/degree")
    public Collection<Degree> Degree() {
        return degreeRepository.findAll().stream().collect(Collectors.toList());
    }
}
