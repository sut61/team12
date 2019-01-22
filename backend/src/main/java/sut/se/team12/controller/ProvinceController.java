package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import sut.se.team12.entity.Province;
import sut.se.team12.repository.ProvinceRepository;

// import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api")

public class ProvinceController {
    @Autowired private ProvinceRepository provinceRepository;

    public ProvinceController(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("/provinces")
    public Collection<Province> Province() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }

}