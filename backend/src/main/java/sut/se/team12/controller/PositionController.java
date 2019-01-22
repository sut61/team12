package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.Position;
import sut.se.team12.repository.PositionRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PositionController {
    @Autowired private PositionRepository positionRepository;
    public PositionController(PositionRepository positionRepository){
        this.positionRepository = positionRepository;
    }
    @GetMapping("/position")
    public Collection<Position> Position() {
        return positionRepository.findAll().stream().collect(Collectors.toList());
    }
}
