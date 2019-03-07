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
public class LockerOrderTest {

	@Autowired private LockerOrderRepository lockerOrderRepository;
	@Autowired private AdminRepository adminRepository;
	@Autowired private MemberRepository memberRepository;
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private LockerRepository lockerRepository;
	@Autowired private LockerDurationRepository lockerDurationRepository;
	@Autowired private FieldRepository fieldRepository;
	@Autowired private FieldDurationRepository fieldDurationRepository;
	@Autowired private LeaseRepository leaseRepository;
	@Autowired private LeaseDurationRepository leaseDurationRepository;
	@Autowired private LeaseAccessoryRepository leaseAccessoryRepository;
	@Autowired private TicketRepository ticketRepository;
	@Autowired private TicketTypeRepository ticketTypeRepository;
	@Autowired private PrivilegeRepository privilegeRepository;
	@Autowired private ProvinceRepository provinceRepository;
	@Autowired private RoomCancelOrderRepository roomCancelOrderRepository;
	@Autowired private RoomStatusRepository roomStatusRepository;
    @Autowired private RoomRepository roomRepository;
	@Autowired private RoomDurationRepository roomDurationRepository;
	
	@Autowired TitleRepository titleRepository;
	@Autowired DegreeRepository degreeRepositiry;
	@Autowired PositionRepository positionRepository;
	@Autowired TrainingRepository trainingRepository;
	@Autowired TrainingTypeRepository trainingTypeRepository;
	@Autowired TrainingProgramRepository trainingProgramRepository;

    @Autowired private TestEntityManager entityManager;



    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	
	//-------------------------------------------------Spring2LockerOrder-------------------------------------------------
	//ทดสอบ save LockOrder ทุกตัว
	@Test
	public void testLockerOrder(){
		LockerOrder l = new LockerOrder();
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Locker _Locker = lockerRepository.findByLockerId(1L);
		LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


		l.setAdmin(_admin);
		l.setMember(_member);
		l.setLocker(_Locker);
		l.setLockerDuration(_lockerDuration);
		l.setNote("Sasiprapha");
		l.setDate(new Date());

        try {
            entityManager.persist(l);
			entityManager.flush();
			System.out.println();
			System.out.println("-----------------> บันทึกปกติ <------------------");
			System.out.println();
			System.out.println();
			System.out.println();

           // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
        }
	}


//ทดสอบ ห้าม Note เป็น NotNull
	@Test
    public void testNoteCannotBeNull() {
		LockerOrder l = new LockerOrder();
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Locker _Locker = lockerRepository.findByLockerId(1L);
		LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


		l.setAdmin(_admin);
		l.setMember(_member);
		l.setLocker(_Locker);
		l.setLockerDuration(_lockerDuration);
		l.setNote(null);
		l.setDate(new Date());

        try {
            entityManager.persist(l);
            entityManager.flush();
			fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("-----------------> Note notnull <------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	//ทดสอบ  Note ไม่ตรง  Pattern
	@Test
    public void testNoteNotPattern() {
		LockerOrder l = new LockerOrder();
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Locker _Locker = lockerRepository.findByLockerId(1L);
		LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


		l.setAdmin(_admin);
		l.setMember(_member);
		l.setLocker(_Locker);
		l.setLockerDuration(_lockerDuration);
		l.setNote("-------");
		l.setDate(new Date());

        try {
            entityManager.persist(l);
            entityManager.flush();
			fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("-----------------> Note ไม่ตรง Patterm <------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	


	//ทดสอบ  Note ความยาวไม่ถึง
	@Test
    public void testNoteSizeShort() {
		LockerOrder l = new LockerOrder();
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Locker _Locker = lockerRepository.findByLockerId(1L);
		LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


		l.setAdmin(_admin);
		l.setMember(_member);
		l.setLocker(_Locker);
		l.setLockerDuration(_lockerDuration);
		l.setNote("a");
		l.setDate(new Date());

        try {
            entityManager.persist(l);
            entityManager.flush();
			fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("-----------------> Note สั้น <------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	
//ทดสอบ  Note ความยาวเกิน
@Test
public void testNoteSizeOver() {
	LockerOrder l = new LockerOrder();
	Admin _admin = adminRepository.findByAdminId(1L);
	Member _member = memberRepository.findByMemberId(1L);
	Locker _Locker = lockerRepository.findByLockerId(1L);
	LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


	l.setAdmin(_admin);
	l.setMember(_member);
	l.setLocker(_Locker);
	l.setLockerDuration(_lockerDuration);
	l.setNote("aaaaaaaaaaddddddddddhhhhhhhhhhh");
	l.setDate(new Date());

	try {
		entityManager.persist(l);
		entityManager.flush();
		fail("Should not pass to this line");
	} catch(javax.validation.ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 1);
		System.out.println();
		System.out.println("-----------------> Note ความยาวเกิน <------------------");
		System.out.println(e.getMessage());
		System.out.println();
		System.out.println();
	}
 }
//ทดสอบ Date ห้ามว่าง
@Test
public void testLockerDateCannotBeNull() {
		LockerOrder l = new LockerOrder();
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Locker _Locker = lockerRepository.findByLockerId(1L);
		LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


		l.setAdmin(_admin);
		l.setMember(_member);
		l.setLocker(_Locker);
		l.setLockerDuration(_lockerDuration);
		l.setNote("Sasiprapha");
		l.setDate(null);

		try {
            entityManager.persist(l);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("-----------------------------------> LockerOrder Date NotNull <--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
}




//ทดสอบ Admin ห้ามว่าง
@Test
public void testLockerAdminCannotBeNull() {
	LockerOrder l = new LockerOrder();
	Admin _admin = adminRepository.findByAdminId(1L);
	Member _member = memberRepository.findByMemberId(1L);
	Locker _Locker = lockerRepository.findByLockerId(1L);
	LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


	l.setAdmin(null);
	l.setMember(_member);
	l.setLocker(_Locker);
	l.setLockerDuration(_lockerDuration);
	l.setNote("HelloWorld");
	l.setDate(new Date());

		try {
            entityManager.persist(l);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("-----------------------------------> Admin NotNull <--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
}
//ทดสอบ Select Member ห้ามว่าง
@Test
public void testLockerMemberCannotBeNull() {
	LockerOrder l = new LockerOrder();
	Admin _admin = adminRepository.findByAdminId(1L);
	Member _member = memberRepository.findByMemberId(1L);
	Locker _Locker = lockerRepository.findByLockerId(1L);
	LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


	l.setAdmin(_admin);
	l.setMember(null);
	l.setLocker(_Locker);
	l.setLockerDuration(_lockerDuration);
	l.setNote("HelloWorld");
	l.setDate(new Date());

		try {
            entityManager.persist(l);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("-----------------------------------> Member NotNull <--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
}
//ทดสอบ Select Locker ห้ามว่าง
@Test
public void testLockerLockerCannotBeNull() {
	LockerOrder l = new LockerOrder();
	Admin _admin = adminRepository.findByAdminId(1L);
	Member _member = memberRepository.findByMemberId(1L);
	Locker _Locker = lockerRepository.findByLockerId(1L);
	LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


	l.setAdmin(_admin);
	l.setMember(_member);
	l.setLocker(null);
	l.setLockerDuration(_lockerDuration);
	l.setNote("HelloWorld");
	l.setDate(new Date());

		try {
            entityManager.persist(l);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("-----------------------------------> Locker NotNull <--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
}

//ทดสอบ Select LockerDuration ห้ามว่าง
@Test
public void testFieldFieldDurationCannotBeNull() {
	LockerOrder l = new LockerOrder();
	Admin _admin = adminRepository.findByAdminId(1L);
	Member _member = memberRepository.findByMemberId(1L);
	Locker _Locker = lockerRepository.findByLockerId(1L);
	LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


	l.setAdmin(_admin);
	l.setMember(_member);
	l.setLocker(_Locker);
	l.setLockerDuration(null);
	l.setNote("HelloWorld");
	l.setDate(new Date());

		try {
            entityManager.persist(l);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("-----------------------------------> LockerDuration NotNull <--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	
// ทดสอบ unique Id LockerOrderId

@Test(expected=javax.persistence.PersistenceException.class) 
	public void testLockerOrderIdMustBeUnique(){
		
		
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Locker _Locker = lockerRepository.findByLockerId(1L);
		LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);

		LockerOrder l = new LockerOrder();
		l.setLockerOrderId(1l);
		l.setAdmin(_admin);
		l.setMember(_member);
		l.setLocker(_Locker);
		l.setLockerDuration(_lockerDuration);
		l.setNote("Sasiprapha");
		l.setDate(new Date());
		entityManager.persist(l);
		entityManager.flush();

		LockerOrder l1 = new LockerOrder();
		l.setLockerOrderId(1l);
		l1.setAdmin(_admin);
		l1.setMember(_member);
		l1.setLocker(_Locker);
		l1.setLockerDuration(_lockerDuration);
		l1.setNote("Sasiprapha");
		l1.setDate(new Date());

		try {
            entityManager.persist(l1);
			entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- LockerOrder _ id _ found not unique ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}



}
