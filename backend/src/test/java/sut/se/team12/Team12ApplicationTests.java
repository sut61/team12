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
public class Team12ApplicationTests {

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

	@Test
	public void contextLoads() {
	}	 
//-------------------------------------------------Spring1FieldOrder-------------------------------------------------
//ทดสอบ save FieldOrder ทุกตัว
@Test
public void testFieldOrder(){
	FieldOrder f = new FieldOrder();
	Admin _admin = adminRepository.findByAdminId(1L);
	Member _member = memberRepository.findByMemberId(1L);
	Field _field = fieldRepository.findByFieldId(1L);
	FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);


	f.setAdmin(_admin);
	f.setMember(_member);
	f.setField(_field);
	f.setFieldDuration(_fieldDuration);
	f.setNote("Sasiprapha");
	//f.setDate(date);


	try {
		entityManager.persist(f);
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
    public void testFieldOrderNoteNotNull() {
		FieldOrder f = new FieldOrder();
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Field _field = fieldRepository.findByFieldId(1L);
		FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);


		f.setAdmin(_admin);
		f.setMember(_member);
		f.setField(_field);
		f.setFieldDuration(_fieldDuration);
		f.setNote(null);
		//f.setDate(date);

        try {
            entityManager.persist(f);
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
//ทดสอบ  Note ไม่ตรง  Patterm
		@Test
		public void testFieldOrderNoteNotPatterm() {
		FieldOrder f = new FieldOrder();
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Field _field = fieldRepository.findByFieldId(1L);
		FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);


		f.setAdmin(_admin);
		f.setMember(_member);
		f.setField(_field);
		f.setFieldDuration(_fieldDuration);
		f.setNote("-------");
		//f.setDate(date);
	
			try {
				entityManager.persist(f);
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
		public void testFieldOrderNoteSizeShort() {
		FieldOrder f = new FieldOrder();
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Field _field = fieldRepository.findByFieldId(1L);
		FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);


		f.setAdmin(_admin);
		f.setMember(_member);
		f.setField(_field);
		f.setFieldDuration(_fieldDuration);
		f.setNote("ab");
		//f.setDate(date);
	
			try {
				entityManager.persist(f);
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
	public void testFieldOrderNoteSizeOver() {
		FieldOrder f = new FieldOrder();
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Field _field = fieldRepository.findByFieldId(1L);
		FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);


		f.setAdmin(_admin);
		f.setMember(_member);
		f.setField(_field);
		f.setFieldDuration(_fieldDuration);
		f.setNote("abcdefghijklmop");
		//f.setDate(date);

		try {
			entityManager.persist(f);
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
		//l.setDate(date);

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
		//l.setDate(date);

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
	//ทดสอบ  Note ไม่ตรง  Patterm
	@Test
    public void testNoteNotPatterm() {
		LockerOrder l = new LockerOrder();
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Locker _Locker = lockerRepository.findByLockerId(1L);
		LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


		l.setAdmin(_admin);
		l.setMember(_member);
		l.setLocker(_Locker);
		l.setLockerDuration(_lockerDuration);
		l.setNote("-----------");
		//l.setDate(date);

        try {
            entityManager.persist(l);
            entityManager.flush();
			fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
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
		l.setNote("ab");
		//l.setDate(date);

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
	l.setNote("abcdefghijklmop");
	//l.setDate(date);

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

}
