package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.Field;
import sut.se.team12.repository.FieldRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FieldController {
    @Autowired private FieldRepository fieldRepository;
    public FieldController(FieldRepository fieldRepository){
        this.fieldRepository = fieldRepository;
    }

    @GetMapping("/field")
    public Collection<Field> Field() {
        return fieldRepository.findAll().stream().collect(Collectors.toList());
    }
}
