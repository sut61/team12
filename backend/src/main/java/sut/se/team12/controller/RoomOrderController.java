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
    @Autowired private RoomStatusRepository roomStatusRepository;
    
    public RoomOrderController(RoomOrderRepository roomOrderRepository){
        this.roomOrderRepository = roomOrderRepository;
    }

    // @GetMapping("/roomOrder")
    // public Collection<RoomOrder> RoomOrder() {
    //     return roomOrderRepository.findAll().stream().collect(Collectors.toList());
    // }
    @GetMapping("/roomOrders")
    public Collection<RoomOrder> RoomOrder() {
        return roomOrderRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/roomOrders/status/1")
    public Collection<RoomOrder> RoomOrder2() {
        return roomOrderRepository.findByRoomStatus1().stream().collect(Collectors.toList());
    }
    // @GetMapping("/roomOrders")
    // public Collection<RoomOrder> roomOrder() {
    //     return memberRepository.findAll().stream().collect(Collectors.toList());
    // }

    @PostMapping("/roomOrders/{admin}/{member}/{room}/{duration}/{date}")
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
            RoomStatus _roomStatus = roomStatusRepository.findByroomStatusId(1L);

            newRoomOrder.setAdmin(_admin);
            newRoomOrder.setMember(_member);
            newRoomOrder.setRoom(_room);
            newRoomOrder.setRoomDuration(_roomDuration);
            newRoomOrder.setDate(date);
            newRoomOrder.setRoomStatus(_roomStatus);
        return roomOrderRepository.save(newRoomOrder);
    }
}
