package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sut.se.team12.entity.*;
import sut.se.team12.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoomCancelOrderController {
    //@Autowired private MemberRepository memberRepository;
    @Autowired private AdminRepository adminRepository;
    // @Autowired private RoomRepository roomRepository;
    // @Autowired private RoomDurationRepository roomDurationRepository;
    @Autowired private RoomOrderRepository roomOrderRepository;
    @Autowired private RoomStatusRepository roomStatusRepository;
    @Autowired private RoomCancelOrderRepository roomCancelOrderRepository;

    public RoomCancelOrderController(RoomCancelOrderRepository roomCancelOrderRepository){
        this.roomCancelOrderRepository = roomCancelOrderRepository;
    }

    // @GetMapping("/roomOrder")
    // public Collection<RoomOrder> RoomOrder() {
    //     return roomOrderRepository.findAll().stream().collect(Collectors.toList());
    // }
    @GetMapping("/roomCancel")
    public Collection<RoomCancelOrder> RoomCancelOrder() {
        return roomCancelOrderRepository.findAll().stream().collect(Collectors.toList());
    }
    // @GetMapping("/roomOrders")
    // public Collection<RoomOrder> roomOrder() {
    //     return memberRepository.findAll().stream().collect(Collectors.toList());
    // }

    @PostMapping("/roomCancel/{roomOrder}/{note}/{admin}")
    public RoomCancelOrder roomCancelOrder(
         @PathVariable Long roomOrder,
         @PathVariable String note,
         @PathVariable Long admin
    ) {

            RoomCancelOrder newRoomCancelOrder = new RoomCancelOrder();

            Admin _admin = adminRepository.findByAdminId(admin);
            RoomStatus _roomStatus = roomStatusRepository.findByroomStatusId(2L);
            RoomOrder _roomOrder = roomOrderRepository.findByRoomOrderId(roomOrder);

            // newRoomOrder.setAdmin(_admin);
            // newRoomOrder.setMember(_member);
            // newRoomOrder.setRoom(_room);
            // newRoomOrder.setRoomDuration(_roomDuration);

            _roomOrder.setRoomStatus(_roomStatus);

            newRoomCancelOrder.setAdmin(_admin);
            newRoomCancelOrder.setRoomOrder(_roomOrder);
            newRoomCancelOrder.setNote(note);
            newRoomCancelOrder.setDate(new Date());
            newRoomCancelOrder.setRoomStatus(_roomStatus);
        return roomCancelOrderRepository.save(newRoomCancelOrder);

    }
}
