package sut.se.team12.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.RoomStatus;
import sut.se.team12.repository.RoomStatusRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoomStatusController {
    @Autowired private RoomStatusRepository roomStatusRepository;
    public RoomStatusController(RoomStatusRepository roomStatusRepository){
        this.roomStatusRepository =  roomStatusRepository;
    }

    @GetMapping("/roomStatus")
    public Collection<RoomStatus> roomStatus() {
        return  roomStatusRepository.findAll().stream().collect(Collectors.toList());
    }
}
