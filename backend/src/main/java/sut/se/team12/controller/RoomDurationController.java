package sut.se.team12.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.RoomDuration;
import sut.se.team12.repository.RoomDurationRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoomDurationController {
    @Autowired private RoomDurationRepository roomDurationRepository;
    public RoomDurationController(RoomDurationRepository roomDurationRepository){
        this.roomDurationRepository = roomDurationRepository;
    }

    @GetMapping("/roomDuration")
    public Collection<RoomDuration> fieldDuration() {
        return roomDurationRepository.findAll().stream().collect(Collectors.toList());
    }
}
