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
public class FieldOrderController {
    @Autowired private MemberRepository memberRepository;
    @Autowired private AdminRepository adminRepository;
    @Autowired private FieldRepository fieldRepository;
    @Autowired private FieldDurationRepository fieldDurationRepository;


    @Autowired private FieldOrderRepository fieldOrderRepository;
    public FieldOrderController(FieldOrderRepository fieldOrderRepository){
        this.fieldOrderRepository = fieldOrderRepository;
    }

    @GetMapping("/fieldOrder")
    public Collection<FieldOrder> fieldOrder() {
        return fieldOrderRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/fieldOrder/{admin}/{member}/{field}/{duration}/{date}")
    public FieldOrder fieldOrder(
        @PathVariable Long admin, 
        @PathVariable Long member,
        @PathVariable Long field,
        @PathVariable Long duration,
        @PathVariable Date date) throws ParseException {

            FieldOrder newFieldOrder = new FieldOrder();

            Admin _admin = adminRepository.findByAdminId(admin);
            Member _member = memberRepository.findByMemberId(member);
            Field _field = fieldRepository.findByFieldId(field);
            FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(duration);

            newFieldOrder.setAdmin(_admin);
            newFieldOrder.setMember(_member);
            newFieldOrder.setField(_field);
            newFieldOrder.setFieldDuration(_fieldDuration);
            newFieldOrder.setDate(date);
        return fieldOrderRepository.save(newFieldOrder);
    }
}
