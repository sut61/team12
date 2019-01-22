package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.Title;
import sut.se.team12.repository.TitleRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TitleController {
    @Autowired private TitleRepository titleRepository;
    public TitleController(TitleRepository titleRepository){
        this.titleRepository = titleRepository;
    }
    @GetMapping("/title")
    public Collection<Title> Title() {
        return titleRepository.findAll().stream().collect(Collectors.toList());
    }
}
