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

    @PostMapping("/members/register/{privilege}/{title}/{firstName}/{lastName}/{age}/{birthday}/{phoneNumber}/{email}/{address}/{subDistrict}/{district}/{province}/{admin}")
    public Member newMember(@RequestBody Member newMember,
                            @PathVariable Long privilege,
                            @PathVariable Long title,
                            @PathVariable String firstName,
                            @PathVariable String lastName,
                            @PathVariable int age,
                            @PathVariable Date birthday,
                            @PathVariable String phoneNumber,
                            @PathVariable String email,
                            @PathVariable String address,
                            @PathVariable String subDistrict,
                            @PathVariable String district,
                            @PathVariable Long province,
                            @PathVariable Long admin                      
    ) 
{
        Admin adminReg = adminRepository.findByAdminId(admin);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(privilege);
        Province provinceMember = provinceRepository.findByProvinceId(province);
        Title titleMember = titleRepository.findByTitleId(title);

        newMember.setPrivilege(privilegeMember);
        newMember.setTitle(titleMember);
        newMember.setFirstName(firstName);
        newMember.setLastName(lastName);
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