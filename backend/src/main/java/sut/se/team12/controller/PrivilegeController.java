package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import sut.se.team12.repository.PrivilegeRepository;
import sut.se.team12.entity.Privilege;
// import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api")

public class PrivilegeController {
    @Autowired private PrivilegeRepository privilegeRepository;

    public PrivilegeController(PrivilegeRepository privilegeRepository){
        this.privilegeRepository = privilegeRepository;
    }

    @GetMapping("/privileges")
    public Collection<Privilege> Privilege() {
        return privilegeRepository.findAll().stream().collect(Collectors.toList());
    }

}