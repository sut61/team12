package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sut.se.team12.entity.*;
import sut.se.team12.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.text.ParseException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LeaseController {
    @Autowired private LeaseRepository leaseRepository;
    @Autowired private LeaseAccessoryRepository accessoryRepository;
    @Autowired private LeaseDurationRepository durationRepository;
    @Autowired private AdminRepository adminRepository;
    @Autowired private MemberRepository memberRepository;
    public LeaseController(LeaseRepository leaseRepository){
        this.leaseRepository = leaseRepository;
    }

    @GetMapping("/lease")
    public Collection<Lease> Admin() {
        return leaseRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/lease/{admin}/{member}/{accesory}/{duration}/{note}")
    public Lease lease(
        @PathVariable Long admin,
        @PathVariable Long member,
        @PathVariable Long accesory,
        @PathVariable Long duration,
        @PathVariable String note
        

    ) throws ParseException{
        Lease newLease = new Lease();

        Admin _admin = adminRepository.findByAdminId(admin);
        Member _member = memberRepository.findByMemberId(member);
        LeaseAccessory _accessory = accessoryRepository.findByAccessoryId(accesory);
        LeaseDuration _duration = durationRepository.findByDurationId(duration);
        newLease.setAdmin(_admin);
        newLease.setMember(_member);
        newLease.setAccessory(_accessory);
        newLease.setDuration(_duration);
        newLease.setNote(note);
    return leaseRepository.save(newLease);

    }
}
