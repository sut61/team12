package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ch.qos.logback.classic.pattern.DateConverter;
import sut.se.team12.entity.*;
import sut.se.team12.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.text.ParseException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NotificationController {
    @Autowired private NotificationRepository notificationRepository;
    @Autowired private AdminRepository adminRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private FieldRepository fieldRepository;
    public NotificationController(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }
    @GetMapping("/notification")
    public Collection<Notification> Title() {
        return notificationRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/notification/{admin}/{employee}/{field}/{note}")
    public Notification notification(
        @PathVariable Long admin,
        @PathVariable Long employee,
        @PathVariable Long field,
        @PathVariable String note
    )throws ParseException{
        Notification newNotification = new Notification();
        Admin _admin = adminRepository.findByAdminId(admin);
        Employee _employee = employeeRepository.findByEmployeeId(employee);
        Field _field = fieldRepository.findByFieldId(field);


        newNotification.setAdmin(_admin);
        newNotification.setEmployee(_employee);
        newNotification.setField(_field);
        newNotification.setNote(note);
        return notificationRepository.save(newNotification);

    }
}
