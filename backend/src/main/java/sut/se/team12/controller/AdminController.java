package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.Admin;
import sut.se.team12.entity.Login;
import sut.se.team12.repository.AdminRepository;
import sut.se.team12.repository.LoginRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
    @Autowired private AdminRepository adminRepository;
    @Autowired private LoginRepository loginRepository;
    public AdminController(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }
    @GetMapping("/admin")
    public Collection<Admin> Admin() {
        return adminRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/admin/{username}/{password}")
    public boolean admin1(@PathVariable String username, @PathVariable String password) {
        Admin admin = adminRepository.findByUsername(username);
        String p = admin.getPassword();
        System.out.println(username);
        System.out.println(p + " = " + password);
        if(p.matches(password) == true){
            login(username);
         }
        return p.matches(password);
    }

    @GetMapping("/admin/getByUsername/{username}")
    public Admin admin2(@PathVariable String username) {
        Admin   adminData    = adminRepository.findByUsername(username);
        return adminData;
    }
    // @PostMapping("/admin/{username}")
    // public Admin admin3(@PathVariable String username){
    //     Admin admin = adminRepository.findByUsername(username);
    //     return admin;
    // }
    public Login login(String username){
        Admin admin = adminRepository.findByUsername(username);
        Login login = new Login();
        login.setAdmin(admin);
        return loginRepository.save(login);
    }
}
