package sut.se.team12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Date;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import sut.se.team12.entity.*;
import sut.se.team12.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
// @SpringBootTest
@DataJpaTest
public class Team12Tests {

	@Autowired private AdminRepository adminRepository;
	@Autowired private PrivilegeRepository privilegeRepository;
	@Autowired private ProvinceRepository provinceRepository;
	@Autowired private TitleRepository titleRepository;

    @Autowired private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testMemberNormal() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("punpun");
		s.setLastName("Abcd");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

		try{
            entityManager.persist(s);
			entityManager.flush();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Test Member Pass---------------------------");
			System.out.println();
			System.out.println();
			System.out.println("All field true data");
			System.out.println();
			System.out.println();
		}catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			
			
		}
	}

	@Test(expected=javax.persistence.PersistenceException.class)
    public void testMemberIdMustBeUnique() {
		
        Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setMemberId(1L);
		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("taan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("36 gre");
		s.setSubDistrict("buayai");
		s.setDistrict("bauyai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

		entityManager.persist(s);
		entityManager.flush();

		Member s1 = new Member();

		Admin adminReg1 = adminRepository.findByAdminId(1L);
        Privilege privilegeMember1 = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember1 = provinceRepository.findByProvinceId(1L);
		Title titleMember1 = titleRepository.findByTitleId(1L);

		s1.setMemberId(1L);
		s1.setPrivilege(privilegeMember1);
		s1.setTitle(titleMember1);
        s1.setFirstName("Kriss");
		s1.setLastName("Asava");
		s1.setAge(20);
		s1.setBirthday(new Date());
		s1.setEmail("tan@gma.com");
		s1.setPhoneNumber("0987654321");
		s1.setAddress("36 greee");
		s1.setSubDistrict("buayai");
		s1.setDistrict("bauyai");
		s1.setProvince(provinceMember1);
		s1.setAdmin(adminReg1);

        try {
            entityManager.persist(s1);
            entityManager.flush();

            fail("Member Id not unique");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Id Unique---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}

	}

	@Test 
	public void testMemberFirstNameCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName(null);
		s.setLastName("Abcd");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("firstname must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Firstname not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
@Test
	public void testMemberFirstNameTooShortLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("p");
		s.setLastName("Abcd");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);


        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("member firstname out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Firstname Short---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	
	@Test
	public void testMemberFirstNameTooLongLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("qwertyuiopasdfghjklzx");
		s.setLastName("Abcd");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);


        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("member firstname out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------member lastname Long---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
	public void testMemberFirstNameWrongPattern() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("df2");
		s.setLastName("Abcd");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member Firstname wrong Pattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Lastname Wrong Pattern---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
    public void testMemberLastNameCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("qwsa");
		s.setLastName(null);
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member lastname must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Lastname not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
	@Test
	public void testMemberLastNameTooShortLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("awsj");
		s.setLastName("k");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member lastname out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member lastname Short---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	
	@Test
	public void testMemberLastNameTooLongLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwertyuiopasdfghjklzx");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member name out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Lastname Long---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
	public void testMemberLastNameWrongPattern() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwer2");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);


        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member lastname wrong Pattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Lastname Wrong Pattern---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	
	@Test
    public void testMemberAgeCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(null);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member age must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member age not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
@Test
    public void testMemberBirthdayCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(null);
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member birthday must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member birthday not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
	@Test
    public void testMemberEmailCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail(null);
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member email must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member email not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
	@Test
	public void testMemberEmailTooShortLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("awsj");
		s.setLastName("k");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("n@g.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member email out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member email Short---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	@Test
	public void testMemberEmailTooLongLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwertyuiopasdfghjklzx");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tanhhqwdcfhnk@gmhukjmnboynha.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("email out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member email Long---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
	public void testMemberEmailWrongPattern() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwer2");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gm/a.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);


        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member email wrong Pattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Email Wrong Pattern---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	@Test(expected=javax.persistence.PersistenceException.class)
    public void testMemberEmailMustBeUnique() {
		
        Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("36 gre");
		s.setSubDistrict("buayai");
		s.setDistrict("bauyai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

		entityManager.persist(s);
		entityManager.flush();

		Member s1 = new Member();

		Admin adminReg1 = adminRepository.findByAdminId(1L);
        Privilege privilegeMember1 = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember1 = provinceRepository.findByProvinceId(1L);
		Title titleMember1 = titleRepository.findByTitleId(1L);

		s1.setPrivilege(privilegeMember1);
		s1.setTitle(titleMember1);
        s1.setFirstName("Kriss");
		s1.setLastName("Asava");
		s1.setAge(20);
		s1.setBirthday(new Date());
		s1.setEmail("tan@gma.com");
		s1.setPhoneNumber("0987654321");
		s1.setAddress("36 greee");
		s1.setSubDistrict("buayai");
		s1.setDistrict("bauyai");
		s1.setProvince(provinceMember1);
		s1.setAdmin(adminReg1);

        try {
            entityManager.persist(s1);
            entityManager.flush();

            fail("Member email not unique");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Email Unique---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}

	}

	@Test
    public void testMemberPhoneNumberCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber(null);
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("phoneNumber must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Phone Number not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
	@Test
	public void testMemberPhoneNumberTooShortLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("awsj");
		s.setLastName("k");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("09854321");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member phoneNumber out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member phone number Short---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	
	@Test
	public void testMemberPhoneNumberTooLongLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwertyuiopasdfghjklzx");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("098765432341");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("member phoneNumber out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Phone number Long---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
	public void testMemberPhoneNumberWrongPattern() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwer2");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("098765432A");
		s.setAddress("123 rd");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);


        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member phonenumber wrong Pattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Phone number Wrong Pattern---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
    public void testMemberAddressCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress(null);
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("address must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Address not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
	@Test
	public void testMemberAddressTooShortLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("awsj");
		s.setLastName("k");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("09854321");
		s.setAddress("1");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member address out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member address Short---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	@Test
	public void testMemberAddressTooLongLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwertyuiopasdfghjklzx");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("098765432341");
		s.setAddress("123456783 rdddwdwfwfwfwfwfw 123456783 rdddwdwfwfwfwfwfw");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("member address out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Address Long---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
	public void testMemberAddressWrongPattern() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwer2");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("098765432A");
		s.setAddress("123 rd$");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);


        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member address wrong Pattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Address Wrong Pattern---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}



	@Test
    public void testMemberSubDistrictCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("36 gre");
		s.setSubDistrict(null);
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("SubDistrict must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member SubDistrict not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
	@Test
	public void testMemberSubDistrictTooShortLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("awsj");
		s.setLastName("k");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("09854321");
		s.setAddress("178 ghk");
		s.setSubDistrict("bui");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member SubDistrict out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member SubDistrict Short---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	@Test
	public void testMemberSubDistrictTooLongLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwertyuiopasdfghjklzx");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("098765432341");
		s.setAddress("12 jaa");
		s.setSubDistrict("buayaiyutgjnbvliyfdbf");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("member SubDistrict out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member SubDistrict Long---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
	public void testMemberSubDistrictWrongPattern() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwer2");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("098765432A");
		s.setAddress("123 rd$");
		s.setSubDistrict("buayai24");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);


        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member SubDistrict wrong Pattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 4);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member SubDistrict Wrong Pattern---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	@Test
    public void testMemberDistrictCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("36 gre");
		s.setSubDistrict("buayai");
		s.setDistrict(null);
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member District must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member District not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
	@Test
	public void testMemberDistrictTooShortLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("awsj");
		s.setLastName("k");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("09854321");
		s.setAddress("178 ghk");
		s.setSubDistrict("bulmki");
		s.setDistrict("bui");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member District out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member District Short---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	@Test
	public void testMemberDistrictTooLongLength() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwertyuiopasdfghjklzx");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("098765432341");
		s.setAddress("12 jaa");
		s.setSubDistrict("buayai");
		s.setDistrict("buayaiyutgjnbvliyfdbf");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("member District out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member District Long---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
	public void testMemberDistrictWrongPattern() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
		Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Awdg");
		s.setLastName("qwer2");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("098765432A");
		s.setAddress("123 rd$");
		s.setSubDistrict("buayai24");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);


        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member District wrong Pattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 4);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member District Wrong Pattern---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	@Test
    public void testMemberTitleCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(null);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("36 gre");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member Title must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Title not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}

@Test
    public void testMemberProvinceCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("36 gre");
		s.setSubDistrict("buayai");
		s.setDistrict("bauyai");
		s.setProvince(null);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member Province must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Province not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}

@Test
    public void testMemberPrivilegeCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(null);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("36 gre");
		s.setSubDistrict("buayai");
		s.setDistrict("buayai");
		s.setProvince(provinceMember);
		s.setAdmin(adminReg);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member Privilege must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Privilege not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}

@Test
    public void testMemberAdminCannotBeNull() {
		Member s = new Member();

		Admin adminReg = adminRepository.findByAdminId(1L);
        Privilege privilegeMember = privilegeRepository.findByPrivilegeId(1L);
        Province provinceMember = provinceRepository.findByProvinceId(1L);
		Title titleMember = titleRepository.findByTitleId(1L);

		s.setPrivilege(privilegeMember);
		s.setTitle(titleMember);
        s.setFirstName("Kriss");
		s.setLastName("Asava");
		s.setAge(20);
		s.setBirthday(new Date());
		s.setEmail("tan@gma.com");
		s.setPhoneNumber("0987654321");
		s.setAddress("36 gre");
		s.setSubDistrict("buayai");
		s.setDistrict("Buayai");
		s.setProvince(provinceMember);
		s.setAdmin(null);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Member Admin must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Member Admin not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}

@Test(expected=javax.persistence.PersistenceException.class)
public void testTitleIdMustBeUnique() {
	
	Title t = new Title();

	t.setTitleId(1L);
	t.setTitleType("mrs");

	entityManager.persist(t);
	entityManager.flush();

	Title t1 = new Title();

	t1.setTitleId(1L);
	t1.setTitleType("miss");

	try {
		entityManager.persist(t1);
		entityManager.flush();

		fail("Title Id not unique");
	} catch(javax.validation.ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 1);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------Title Id Unique---------------------------");
		System.out.println();
		System.out.println();
		System.out.println(e.getMessage());
		System.out.println();
		System.out.println();
	}

}
@Test
    public void testTitleTypeCannotBeNull() {
		Title t = new Title();
		t.setTitleType(null);

        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Title TitleType must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Title TitleType not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
@Test(expected=javax.persistence.PersistenceException.class)
public void testProvinceIdMustBeUnique() {
	
	Province p = new Province();

	p.setProvinceId(1L);
	p.setProvinceName("korat");

	entityManager.persist(p);
	entityManager.flush();

	Province p1 = new Province();

	p1.setProvinceId(1L);
	p1.setProvinceName("koraat");

	try {
		entityManager.persist(p1);
		entityManager.flush();

		fail("Province Id not unique");
	} catch(javax.validation.ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 1);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------Province Id Unique---------------------------");
		System.out.println();
		System.out.println();
		System.out.println(e.getMessage());
		System.out.println();
		System.out.println();
	}

}
@Test
    public void testProvinceNameCannotBeNull() {
		Province p = new Province();
		p.setProvinceName(null);

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Province ProvinceName must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Province ProvinceName not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
@Test(expected=javax.persistence.PersistenceException.class)
public void testPrivilegeIdMustBeUnique() {
	
	Privilege p = new Privilege();

	p.setPrivilegeId(1L);
	p.setPrivilegeName("korat");
	p.setPrice(20.00);

	entityManager.persist(p);
	entityManager.flush();

	Province p1 = new Province();

	p.setPrivilegeId(1L);
	p.setPrivilegeName("koraat");
	p.setPrice(21.00);

	try {
		entityManager.persist(p1);
		entityManager.flush();

		fail("Privilege Id not unique");
	} catch(javax.validation.ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 1);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------Privilege Id Unique---------------------------");
		System.out.println();
		System.out.println();
		System.out.println(e.getMessage());
		System.out.println();
		System.out.println();
	}

}
@Test
    public void testPrivilegeNameCannotBeNull() {
		Privilege p = new Privilege();
		p.setPrivilegeName(null);
		p.setPrice(20.00);

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Privilege PrivilegeName must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Privilege PrivilegeName not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
@Test
    public void testPrivilegePriceCannotBeNull() {
		Privilege p = new Privilege();
		p.setPrivilegeName("VIP");
		p.setPrice(null);

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Privilege Price must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Privilege Price not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}

@Test(expected=javax.persistence.PersistenceException.class)
public void testAdminIdMustBeUnique() {
	
	Admin a = new Admin();

	a.setAdminId(1L);
	a.setName("tantan");
	a.setUsername("tanneuy");
	a.setPassword("1234");

	entityManager.persist(a);
	entityManager.flush();

	Admin a1 = new Admin();

	a1.setAdminId(1L);
	a1.setName("tanan");
	a1.setUsername("taeuy");
	a1.setPassword("12314");


	try {
		entityManager.persist(a1);
		entityManager.flush();

		fail("Admin Id not unique");
	} catch(javax.validation.ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 1);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------Admin Id Unique---------------------------");
		System.out.println();
		System.out.println();
		System.out.println(e.getMessage());
		System.out.println();
		System.out.println();
	}

}
@Test
    public void testAdminNameCannotBeNull() {
		Admin a = new Admin();
		a.setName(null);
		a.setUsername("tanneuy");
		a.setPassword("1234");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("Admin AdminName must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Admin AdminName not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
@Test
    public void testAdminUserNameCannotBeNull() {
		Admin a = new Admin();
		a.setName("tamm");
		a.setUsername(null);
		a.setPassword("1234");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("Admin UserName must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Admin UserName not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
@Test
    public void testAdminPasswordCannotBeNull() {
		Admin a = new Admin();
		a.setName("ttaann");
		a.setUsername("tanneuy");
		a.setPassword(null);

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("Admin Password must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Admin Password not be null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
}
@Test
public void testAdminNormal() {
	Admin a = new Admin();

	a.setName("pan");
	a.setUsername("tatata");
	a.setPassword("1223");

	try{
		entityManager.persist(a);
		entityManager.flush();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------Admin Test Pass---------------------------");
		System.out.println();
		System.out.println();
		System.out.println("All field true data");
		System.out.println();
		System.out.println();
	}catch(javax.validation.ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 1);
		
		
	}

	
}
@Test
public void testTitleNormal() {
	Title t = new Title();

	t.setTitleType("Mr.");

	try{
		entityManager.persist(t);
		entityManager.flush();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------Title Test Pass---------------------------");
		System.out.println();
		System.out.println();
		System.out.println("All field true data");
		System.out.println();
		System.out.println();
	}catch(javax.validation.ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 1);
		
		
	}

	
}
@Test
public void testProvinceNormal() {
	Province p = new Province();

	p.setProvinceName("Bangkok");

	try{
		entityManager.persist(p);
		entityManager.flush();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------Province Test Pass---------------------------");
		System.out.println();
		System.out.println();
		System.out.println("All field true data");
		System.out.println();
		System.out.println();
	}catch(javax.validation.ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 1);
		
		
	}

	
}
@Test
public void testPrivilegeNormal() {
	Privilege p = new Privilege();

	p.setPrivilegeName("VIP");
	p.setPrice(20.00);
	try{
		entityManager.persist(p);
		entityManager.flush();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------Privilege Test Pass---------------------------");
		System.out.println();
		System.out.println();
		System.out.println("All field true data");
		System.out.println();
		System.out.println();
	}catch(javax.validation.ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 1);
		
		
	}

	
}
}