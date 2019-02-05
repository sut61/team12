package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.*;
import sut.se.team12.repository.*;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LockerOrderController {
    @Autowired private MemberRepository memberRepository;
    @Autowired private AdminRepository adminRepository;
    @Autowired private LockerRepository lockerRepository;
    @Autowired private LockerDurationRepository lockerDurationRepository;


    @Autowired private LockerOrderRepository lockerOrderRepository;
    public LockerOrderController(LockerOrderRepository lockerOrderRepository){
        this.lockerOrderRepository = lockerOrderRepository;
    }

    @GetMapping("/lockerOrder")
    public Collection<LockerOrder> lockerOrder() {
    return lockerOrderRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/lockerOrder/{admin}/{member}/{locker}/{lockerDuration}/{note}/{date}")
    public LockerOrder lockerOrder(
        @PathVariable Long admin, 
        @PathVariable Long member,
        @PathVariable Long locker,
        @PathVariable Long lockerDuration,
        @PathVariable String note,
        @PathVariable Date date) throws ParseException {

            LockerOrder newLockerOrder = new LockerOrder();

            Admin _admin = adminRepository.findByAdminId(admin);
            Member _member = memberRepository.findByMemberId(member);
            Locker _Locker = lockerRepository.findByLockerId(locker);
            LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(lockerDuration);

            newLockerOrder.setAdmin(_admin);
            newLockerOrder.setMember(_member);
            newLockerOrder.setLocker(_Locker);
            newLockerOrder.setLockerDuration(_lockerDuration);
            newLockerOrder.setNote(note);
            newLockerOrder.setDate(date);
        return lockerOrderRepository.save(newLockerOrder);
    }
}
