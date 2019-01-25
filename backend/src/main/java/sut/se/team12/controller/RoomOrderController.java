package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sut.se.team12.entity.*;
import sut.se.team12.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.text.ParseException;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoomOrderController {
    @Autowired private MemberRepository memberRepository;
    @Autowired private AdminRepository adminRepository;
    @Autowired private RoomRepository roomRepository;
    @Autowired private RoomDurationRepository roomDurationRepository;


    @Autowired private RoomOrderRepository roomOrderRepository;
    public RoomOrderController(RoomOrderRepository roomOrderRepository){
        this.roomOrderRepository = roomOrderRepository;
    }

    @GetMapping("/roomOrder")
    public Collection<RoomOrder> fieldOrder() {
        return roomOrderRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/roomOrder/{admin}/{member}/{room}/{duration}/{date}")
    public RoomOrder roomOrder(
        @PathVariable Long admin, 
        @PathVariable Long member,
        @PathVariable Long room,
        @PathVariable Long duration,
        @PathVariable Date date) throws ParseException {

            RoomOrder newRoomOrder = new RoomOrder();

            Admin _admin = adminRepository.findByAdminId(admin);
            Member _member = memberRepository.findByMemberId(member);
            Room _room = roomRepository.findByRoomId(room);
            RoomDuration _roomDuration = roomDurationRepository.findByroomDurationId(duration);

            newRoomOrder.setAdmin(_admin);
            newRoomOrder.setMember(_member);
            newRoomOrder.setRoom(_room);
            newRoomOrder.setRoomDuration(_roomDuration);
            newRoomOrder.setDate(date);
        return roomOrderRepository.save(newRoomOrder);
    }
}
