package sut.se.team12.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.Room;
import sut.se.team12.repository.RoomRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoomController {
    @Autowired private RoomRepository roomrepository;
    public RoomController(RoomRepository roomrepository){
        this.roomrepository = roomrepository;
    }

    @GetMapping("/room")
    public Collection<Room> Field() {
        return roomrepository.findAll().stream().collect(Collectors.toList());
    }
}
