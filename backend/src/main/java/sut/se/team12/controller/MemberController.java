package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import sut.se.team12.repository.*;
import sut.se.team12.entity.*;
// import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api")

public class MemberController {
    @Autowired private MemberRepository memberRepository;
    @Autowired private AdminRepository adminRepository;
    @Autowired private PrivilegeRepository privilegeRepository;
    @Autowired private ProvinceRepository provinceRepository;
    @Autowired private TitleRepository titleRepository;

    public MemberController(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @GetMapping("/members")
    public Collection<Member> Member() {
        return memberRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/members/{privilege}/{title}/{name}/{age}/{birthday}/{phoneNumber}/{email}/{address}/{subDistrict}/{district}/{province}/{admin}")
    public Member newMember(@RequestBody Member newMember,
                            @PathVariable String privilege,
                            @PathVariable String title,
                            @PathVariable String name,
                            @PathVariable Integer age,
                            @PathVariable Date birthday,
                            @PathVariable String phoneNumber,
                            @PathVariable String email,
                            @PathVariable String address,
                            @PathVariable String subDistrict,
                            @PathVariable String district,
                            @PathVariable String province,
                            @PathVariable String admin                      
    ) {

        Admin adminReg = adminRepository.findByUsername(admin);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeName(privilege);
        Province provinceMember = provinceRepository.findByProvinceName(province);
        Title titleMember = titleRepository.findByTitleType(title);

        newMember.setPrivilege(privilegeMember);
        newMember.setTitle(titleMember);
        newMember.setName(name);
        newMember.setAge(age);
        newMember.setBirthday(birthday);
        newMember.setPhoneNumber(phoneNumber);
        newMember.setEmail(email);
        newMember.setAddress(address);
        newMember.setSubDistrict(subDistrict);
        newMember.setDistrict(district);
        newMember.setProvince(provinceMember);
        newMember.setAdmin(adminReg);

        return memberRepository.save(newMember);
    }
}