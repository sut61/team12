package sut.se.team12.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.Admin;
import sut.se.team12.repository.AdminRepository;
import sut.se.team12.entity.Login;
import sut.se.team12.repository.LoginRepository;


import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
    @Autowired private AdminRepository adminRepository;
    @Autowired private LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }
    @GetMapping("/admin/login")
    public Collection<Login> Login() {
        return loginRepository.findAll().stream().collect(Collectors.toList());
    }
    // @GetMapping("/admin/login/{username}/{password}")
    // public boolean admin1(@PathVariable String username, @PathVariable String password) {
    //     Login login = loginRepository.findByUsername(username);
    //     String p = admin.getPassword();
    //     System.out.println(username);
    //     System.out.println(p + " = " + password);
    //     return p.matches(password);
    // }

    @GetMapping("/admin/login/getByLoginId/{username}")
    public Login login2(@PathVariable long username) {
        Login   loginData    = loginRepository.findByLoginId(username);
        return loginData;
    }
    @PostMapping("/admin/login/{username}")
    public Login login3(@PathVariable String username){
        
        Login newLogin = new Login();

        Admin admin = adminRepository.findByUsername(username);
        System.out.println(admin);
        newLogin.setLoginId(1L);
        newLogin.setAdmin(admin);
        return loginRepository.save(newLogin);
    }
}