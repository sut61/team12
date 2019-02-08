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
	 //-------------------------------------Sprint1-testRoomCannotBeNull----------------------------
	 @Test
	 public void testRoomCannotBeNull() {
	   RoomOrder r = new RoomOrder();
	   

	   Admin admin1 = adminRepository.findByAdminId(1L);
	   Room room01 = roomRepository.findByRoomId(1L);
	   Member member1 = memberRepository.findByMemberId(1L);
	   RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);


	   r.setRoom(null);
	   r.setAdmin(admin1);
	   r.setRoomDuration(roomDuration01);
	   r.setMember(member1);
	   r.setDate(new Date());

	   try {
		   entityManager.persist(r);
		   entityManager.flush();

		   fail("Should not pass to this line");
	   } catch(javax.validation.ConstraintViolationException e) {
		   Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		   assertEquals(violations.isEmpty(), false);
		   assertEquals(violations.size(), 2);
		   System.out.println();
		   System.out.println();
		   System.out.println("Room is not null");
		   System.out.println(e.getMessage());
		   System.out.println();
	   }
   }
   //-------------------------------------Sprint1-testRoomDurationCannotBeNull----------------------------
   @Test
   public void testRoomDurationCannotBeNull() {
	 RoomOrder r = new RoomOrder();
	 

	 Admin admin1 = adminRepository.findByAdminId(1L);
	 Room room01 = roomRepository.findByRoomId(1L);
	 Member member1 = memberRepository.findByMemberId(1L);
	 RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);


	 r.setRoom(room01);
	 r.setAdmin(admin1);
	 r.setRoomDuration(null);
	 r.setMember(member1);
	 r.setDate(new Date());

	 try {
		 entityManager.persist(r);
		 entityManager.flush();

		 fail("Should not pass to this line");
	 } catch(javax.validation.ConstraintViolationException e) {
		 Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		 assertEquals(violations.isEmpty(), false);
		 assertEquals(violations.size(), 2);
		 System.out.println();
		 System.out.println();
		 System.out.println("RoomDuration is not null");
		 System.out.println(e.getMessage());
		 System.out.println();
	 }
 }
  //-------------------------------------Sprint1-testDateCannotBeNull----------------------------
  @Test
  public void testDateCannotBeNull() {
	RoomOrder r = new RoomOrder();
	

	Admin admin1 = adminRepository.findByAdminId(1L);
	Room room01 = roomRepository.findByRoomId(1L);
	Member member1 = memberRepository.findByMemberId(1L);
	RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);


	r.setRoom(room01);
	r.setAdmin(admin1);
	r.setRoomDuration(roomDuration01);
	r.setMember(member1);
	r.setDate(null);

	try {
		entityManager.persist(r);
		entityManager.flush();

		fail("Should not pass to this line");
	} catch(javax.validation.ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 2);
		System.out.println();
		System.out.println();
		System.out.println("Date is not null");
		System.out.println(e.getMessage());
		System.out.println();
	}
}

   //--------------------------------------Sprint2-testEvethingIsOK----------------------------
   @Test
   public void testEvethingIsOK() {
	   RoomCancelOrder r = new RoomCancelOrder();
	   

	   Admin admin1 = adminRepository.findByAdminId(1L);
	   RoomStatus roomStatus02 = roomStatusRepository.findByroomStatusId(1L);


	   r.setNote("notee");
	   r.setAdmin(admin1);
	   r.setRoomStatus(roomStatus02);
	   r.setDate(new Date());

	   try {
		   entityManager.persist(r);
		   entityManager.flush();
		   System.out.println();
		   System.out.println("Everything is good");
		   System.out.println();
		   System.out.println();
		   System.out.println();
		   //fail("Should not pass to this line");
	   } catch(javax.validation.ConstraintViolationException e) {
		   Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		   assertEquals(violations.isEmpty(), false);
		   assertEquals(violations.size(), 1);
		   
	   }
   }
   
   //-------------------------------------Sprint2-testNoteCannotBeNull----------------------------
   @Test
   public void testRoomNoteCannotBeNull() {
	   RoomCancelOrder r = new RoomCancelOrder();
	   

	   Admin admin1 = adminRepository.findByAdminId(1L);
	   RoomStatus roomStatus02 = roomStatusRepository.findByroomStatusId(1L);


	   r.setNote(null);
	   r.setAdmin(admin1);
	   r.setRoomStatus(roomStatus02);
	   r.setDate(new Date());

	   try {
		   entityManager.persist(r);
		   entityManager.flush();

		   fail("Should not pass to this line");
	   } catch(javax.validation.ConstraintViolationException e) {
		   Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		   assertEquals(violations.isEmpty(), false);
		   assertEquals(violations.size(), 2);
		   System.out.println();
		   System.out.println();
		   System.out.println("Note is not null");
		   System.out.println(e.getMessage());
		   System.out.println();
	   }
   }
   //--------------------------------------Sprint2-testNoteAerTooLong------------------------------------------
   @Test
   public void testNoteAerTooLong() {
	   RoomCancelOrder r = new RoomCancelOrder();
	   

	   Admin admin1 = adminRepository.findByAdminId(1L);
	   RoomStatus roomStatus02 = roomStatusRepository.findByroomStatusId(1L);


	   r.setNote("nnnnnooooottttteeeeennnnnooooottttteeeee");
	   r.setAdmin(admin1);
	   r.setRoomStatus(roomStatus02);
	   r.setDate(new Date());

	   try {
		   entityManager.persist(r);
		   entityManager.flush();

		   fail("Should not pass to this line");
	   } catch(javax.validation.ConstraintViolationException e) {
		   Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		   assertEquals(violations.isEmpty(), false);
		   assertEquals(violations.size(), 2);
		   System.out.println();
		   System.out.println();
		   System.out.println("Note is too long");
		   System.out.println(e.getMessage());
		   System.out.println();
	   }
   }
   //-------------------------------Sprint2-testNoteAerTooShort---------------------------------------
   @Test
   public void testNoteAerTooShort() {
	   RoomCancelOrder r = new RoomCancelOrder();
	   

	   Admin admin1 = adminRepository.findByAdminId(1L);
	   RoomStatus roomStatus02 = roomStatusRepository.findByroomStatusId(1L);


	   r.setNote("n");
	   r.setAdmin(admin1);
	   r.setRoomStatus(roomStatus02);
	   r.setDate(new Date());

	   try {
		   entityManager.persist(r);
		   entityManager.flush();

		   fail("Should not pass to this line");
	   } catch(javax.validation.ConstraintViolationException e) {
		   Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		   assertEquals(violations.isEmpty(), false);
		   assertEquals(violations.size(), 2);
		   System.out.println();
		   System.out.println();
		   System.out.println("Note is too short");
		   System.out.println(e.getMessage());
		   System.out.println();
	   }
   }
	//-------------------------------Sprint2-testNotePatternIsWrong---------------------------------------
	@Test
	public void testNotePatternIsWrong() {
		RoomCancelOrder r = new RoomCancelOrder();
		

		Admin admin1 = adminRepository.findByAdminId(1L);
		RoomStatus roomStatus02 = roomStatusRepository.findByroomStatusId(1L);


		r.setNote("-----");
		r.setAdmin(admin1);
		r.setRoomStatus(roomStatus02);
		r.setDate(new Date());

		try {
			entityManager.persist(r);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println();
			System.out.println("Pattern is Wrong");
			System.out.println(e.getMessage());
			System.out.println();
		}
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

//ทดสอบ  Note ห้ามซ้ำ
// @Test
// public void testNoteNotUnique() {
// 	LockerOrder l = new LockerOrder();
// 	Admin _admin = adminRepository.findByAdminId(1L);
// 	Member _member = memberRepository.findByMemberId(1L);
// 	Locker _Locker = lockerRepository.findByLockerId(1L);
// 	LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


// 	l.setAdmin(_admin);
// 	l.setMember(_member);
// 	l.setLocker(_Locker);
// 	l.setLockerDuration(_lockerDuration);
// 	l.setNote("Notebook");
// 	//l.setDate(date);

// 	try {
// 		entityManager.persist(l);
// 		entityManager.flush();
// 		fail("Should not pass to this line");
// 	} catch(javax.validation.ConstraintViolationException e) {
// 		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
// 		assertEquals(violations.isEmpty(), false);
// 		assertEquals(violations.size(), 2);
// 		System.out.println();
// 		System.out.println("-----------------> Note ไม่ซ้ำ <------------------");
// 		System.out.println(e.getMessage());
// 		System.out.println();
// 		System.out.println();
// 	}
// }

//ทดสอบ  Note ห้ามซ้ำ
// @Test
// //(expected=javax.persistence.PersistenceException.class)
// public void testNoteNotUnique() {


// 	Admin _admin = adminRepository.findByAdminId(1L);
// 	Member _member = memberRepository.findByMemberId(1L);
// 	Locker _Locker = lockerRepository.findByLockerId(1L);
// 	LockerDuration _lockerDuration = lockerDurationRepository.findByLockerDurationId(1L);


// 	LockerOrder l1 = new LockerOrder();
// 	l1.setAdmin(_admin);
// 	l1.setMember(_member);
// 	l1.setLocker(_Locker);
// 	l1.setLockerDuration(_lockerDuration);
// 	l1.setNote("abcdefghijklmop");
// 	entityManager.persist(l1);
// 	entityManager.flush();


// 	LockerOrder l2 = new LockerOrder();
// 	l2.setAdmin(_admin);
// 	l2.setMember(_member);
// 	l2.setLocker(_Locker);
// 	l2.setLockerDuration(_lockerDuration);
// 	l2.setNote("abcdefghijklmop");
// 	// entityManager.persist(l2);
// 	// entityManager.flush();

// 	try {
// 		// entityManager.persist(l1);
// 		// entityManager.flush();
// 		entityManager.persist(l2);
// 		entityManager.flush();
// 		fail("Should not pass to this line");
// 	} catch(javax.persistence.PersistenceException e) {
// 		// Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
// 		// assertEquals(violations.isEmpty(), false);
// 		// assertEquals(violations.size(), 1);
// 		System.out.println();
// 		System.out.println("-----------------> Note NotUnique <------------------");
// 		System.out.println(e + " ");
// 		System.out.println();
// 		System.out.println();
// 	}
// }

	//--------------------------------------------------------------------------------------------------------------//
	//--------------------------------------------------> " Lease " <----------------------------------------------//
	//------------------------------------------------------------------------------------------------------------//
	@Test 
	public void testLease(){
		Lease lease1 = new Lease();
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setMember(member1);
		lease1.setAccessory(accessory1);
		lease1.setDuration(duration1);
		lease1.setNote("Borrow soccer");

        try {
            entityManager.persist(lease1);
            entityManager.flush();

            // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------------------------------->Lease Pass<--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }

	}

	@Test 
	public void testLeaseMemberCannotBeNull(){
		Lease lease1 = new Lease();
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setMember(null);
		lease1.setAccessory(accessory1);
		lease1.setDuration(duration1);
		lease1.setNote("Borrow");

        try {
            entityManager.persist(lease1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------------------------------->Member NotNull<--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }

	}

	@Test 
	public void testLeaseAccessoryCannotBeNull(){
		Lease lease1 = new Lease();
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setMember(member1);
		lease1.setAccessory(null);
		lease1.setDuration(duration1);
		lease1.setNote("Borrow");

        try {
            entityManager.persist(lease1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------------------------------->Accessory NotNull<--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }

	}

	@Test 
	public void testLeaseDurationCannotBeNull(){
		Lease lease1 = new Lease();
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setMember(member1);
		lease1.setAccessory(accessory1);
		lease1.setDuration(null);
		lease1.setNote("Borrow");

        try {
            entityManager.persist(lease1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------------------------------->Duration NotNull<--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }

	}


	@Test 
	public void testLeaseNoteCannotBeNull(){
		Lease lease1 = new Lease();
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setMember(member1);
		lease1.setAccessory(accessory1);
		lease1.setDuration(duration1);
		lease1.setNote(null);

        try {
            entityManager.persist(lease1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------------------------------->Note NotNull<--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }

	}

	@Test 
	public void testLeaseNoteShort(){
		Lease lease1 = new Lease();
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setMember(member1);
		lease1.setAccessory(accessory1);
		lease1.setDuration(duration1);
		lease1.setNote("aaa");

        try {
            entityManager.persist(lease1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------------------------------->Note ShortWord<--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }

	}

	@Test 
	public void testLeaseNoteLong(){
		Lease lease1 = new Lease();
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setMember(member1);
		lease1.setAccessory(accessory1);
		lease1.setDuration(duration1);
		lease1.setNote("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        try {
            entityManager.persist(lease1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------------------------------->Note LongWord<--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }

	}

	@Test
	public void testLeaseNotePat() {
		Lease lease1 = new Lease();
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setMember(member1);
		lease1.setAccessory(accessory1);
		lease1.setDuration(duration1);
		lease1.setNote("------");

        try {
            entityManager.persist(lease1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("--------------------------------------------->Note NotPattern<------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	//-----------------------------------------------------------------------------------------------------------------//
	//-----------------------------------------------------> " Notification " <---------------------------------------------------//
	//-----------------------------------------------------------------------------------------------------------------//
	@Test 
	public void testNotification(){
		Notification notification1 = new Notification();

		Admin admin1 = adminRepository.findByAdminId(1L);
		Employee employee2 = employeeRepository.findByEmployeeId(2L);
		Field Field1 = fieldRepository.findByFieldId(1L);

		notification1.setAdmin(admin1);
		notification1.setEmployee(employee2);
		notification1.setField(Field1);
		notification1.setNote("nulla");

        try {
            entityManager.persist(notification1);
            entityManager.flush();

            // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------------------------------->Notification Pass<--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }

	}

	@Test
	public void testNotificationAdminCannotBeNull() {
	
		Notification notification1 = new Notification();

		Admin admin1 = adminRepository.findByAdminId(1L);
		Employee employee2 = employeeRepository.findByEmployeeId(2L);
		Field Field1 = fieldRepository.findByFieldId(1L);

		notification1.setAdmin(null);
		notification1.setEmployee(employee2);
		notification1.setField(Field1);
		notification1.setNote("dekdee");

        try {
            entityManager.persist(notification1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("------------------------------------->Admin Notnull<--------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
    }

	@Test
	public void testNotificationEmployeeCannotBeNull() {
	
		Notification notification1 = new Notification();

		Admin admin1 = adminRepository.findByAdminId(1L);
		Employee employee2 = employeeRepository.findByEmployeeId(2L);
		Field Field1 = fieldRepository.findByFieldId(1L);

		notification1.setAdmin(admin1);
		notification1.setEmployee(null);
		notification1.setField(Field1);
		notification1.setNote("dekdee");

        try {
            entityManager.persist(notification1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("------------------------------------->Employee Notnull<--------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	
	@Test
	public void testNotificationFieldCannotBeNull() {
	
		Notification notification1 = new Notification();

		Admin admin1 = adminRepository.findByAdminId(1L);
		Employee employee2 = employeeRepository.findByEmployeeId(2L);
		Field Field1 = fieldRepository.findByFieldId(1L);

		notification1.setAdmin(admin1);
		notification1.setEmployee(employee2);
		notification1.setField(null);
		notification1.setNote("dekdee");

        try {
            entityManager.persist(notification1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("------------------------------------->Field Notnull<--------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
    }


	@Test
	public void testNotificationNoteCannotBeNull() {
	
		Notification notification1 = new Notification();

		Admin admin1 = adminRepository.findByAdminId(1L);
		Employee employee2 = employeeRepository.findByEmployeeId(2L);
		Field Field1 = fieldRepository.findByFieldId(1L);

		notification1.setAdmin(admin1);
		notification1.setEmployee(employee2);
		notification1.setField(Field1);
		notification1.setNote(null);

        try {
            entityManager.persist(notification1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("------------------------------------->Note notnull<--------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
    }

	@Test
	public void testNotificationNoteSizeShort() {
	
		Notification notification1 = new Notification();

		Admin admin1 = adminRepository.findByAdminId(1L);
		Employee employee2 = employeeRepository.findByEmployeeId(2L);
		Field Field1 = fieldRepository.findByFieldId(1L);

		notification1.setAdmin(admin1);
		notification1.setEmployee(employee2);
		notification1.setField(Field1);
		notification1.setNote("dek");

        try {
            entityManager.persist(notification1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------------------------------------->Note สั้นเกินไป<--------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
    }

	@Test
	public void testNotificationNoteSizeLong() {
	
		Notification notification1 = new Notification();

		Admin admin1 = adminRepository.findByAdminId(1L);
		Employee employee2 = employeeRepository.findByEmployeeId(2L);
		Field Field1 = fieldRepository.findByFieldId(1L);

		notification1.setAdmin(admin1);
		notification1.setEmployee(employee2);
		notification1.setField(Field1);
		notification1.setNote("dekdekdekdekdekdekdekdekdekdekdekdek");

        try {
            entityManager.persist(notification1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("--------------------------------------------->Note ยาวเกินไป<------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	@Test
	public void testNotificationNotePat() {
	
		Notification notification1 = new Notification();

		Admin admin1 = adminRepository.findByAdminId(1L);
		Employee employee2 = employeeRepository.findByEmployeeId(2L);
		Field Field1 = fieldRepository.findByFieldId(1L);

		notification1.setAdmin(admin1);
		notification1.setEmployee(employee2);
		notification1.setField(Field1);
		notification1.setNote("------");

        try {
            entityManager.persist(notification1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("--------------------------------------------->Note NotPattern<------------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	//--------------------------------------------------------------------------------------------------------------------------------------//

	@Test public void testEmployee() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
			entityManager.flush();
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee pass ---------------------------------------");
			System.out.println("\n");

            // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
		
	}

	@Test public void testPersonalIdNotBeNull() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId(null);
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Personal ID should not be null");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ personal id _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testPersonalIdSizeUnder() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("123456789012");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Size of personal ID  not correct");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ personal id _ found size under min ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			// System.out.println("\n");
        }
	}

	@Test public void testPersonalIdSizeOver() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("12345678901234");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Size of personal ID  not correct");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ personal id _ found size over max ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testPersonalIdNotEqualPattern() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("123456abcdfg1");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Pattern of personal ID not correct");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ personal id _ found not pattern ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	
	@Test
	//(expected=javax.persistence.PersistenceException.class)
    public void testIdMustBeUnique(){
        

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		// SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		// String input = "10-10-2012";
		// Date date = new Date();
		// date = dateformat.parse(input);

		Employee e1 = new Employee();
		e1.setAdmin(admin);
		e1.setId("1234567890123");
		e1.setTitle(title);
		e1.setFirstName("Supanniga");
		e1.setLastName("Ogasawara");
		e1.setBirthDate(new Date());
		e1.setPhone("0812345678");
		e1.setEmail("supanniga@gmail.com");
		e1.setAddress("11 SUT");
		e1.setDegree(degree);
		e1.setPosition(position);
        entityManager.persist(e1);
        entityManager.flush();

        Employee e2 = new Employee();
        e2.setAdmin(admin);
		e2.setId("1234567890123");
		e2.setTitle(title);
		e2.setFirstName("Supanniga");
		e2.setLastName("Ogasawara");
		e2.setBirthDate(new Date());
		e2.setPhone("0812345678");
		e2.setEmail("supanniga@gmail.com");
		e2.setAddress("11 SUT");
		e2.setDegree(degree);
		e2.setPosition(position);
		
		try{
			entityManager.persist(e2);
            entityManager.flush();

            fail("Employee _ personal id _ found not unique");
		}catch(javax.persistence.PersistenceException er){
			// Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            // assertEquals(violations.isEmpty(), false);
			// assertEquals(violations.size(), 1);
			// javax.validation.ConstraintViolationException er
			// javax.persistence.PersistenceException er
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ personal id _ found not unique ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
		}
    }


	@Test public void testEmployeeFirstNameNotBeNull() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName(null);
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Employee first name should not be null");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ first name _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeFirstNameSizeUnder() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("S");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ first name _ found size under min ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeFirstNameSizeOver() throws Exception {
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Abcdeabcdeabcdeabcdea");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println("------------------------------------------- Employee _ first name _ found size over max ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	@Test public void testEmployeeFirstNameNotEqualPattern() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Pattern of Employee first name not correct");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ first name _ found not pattern ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeLastNameNotBeNull() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName(null);
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Employee last name should not be null");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ last name _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeLastNameSizeUnder() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("O");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ last name _ found size under min ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeLastNameSizeOver() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Abcdeabcdeabcdeabcdea");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ last name _ found size over max ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeLastNameNotEqualPattern() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Pattern of employee last name not correct");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ last name _ found not pattern ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeBirthDateNotBeNull() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(null);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Employee birth date should not be null");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ birth date _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeePhoneNotBeNull() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone(null);
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Employee phone should not be null");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ phone _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeePhoneSizeUnder() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("081234567");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Size of employee phone not correct");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ phone _ found size under min ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeePhoneSizeOver() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("08123456789");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Size of employee phone not correct");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ phone _ found size over max ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeePhoneNotEqualPattern() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812ab5678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Pattern of employee phone not correct");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ phone _ found not pattern ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeEmailNotBeNull() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail(null);
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Employee email should not be null");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ email _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeEmailSizeUnder() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("s@g.c"); //djwkjwlegjwo
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ email _ found size under min ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeEmailNotEqualPattern() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Pattern of employee email not correct");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ email _ found not pattern ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeAddressNotBeNull() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress(null);
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Employee address should not be null");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ address _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
		
	}

	@Test public void testEmployeeAdminNotBeNull() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(null);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ admin _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeTitleNotBeNull() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(null);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ title _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeeDegreeNotBeNull() throws Exception {
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(null);
		e.setPosition(position);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ degree _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testEmployeePositionNotBeNull() throws Exception{
		Employee e = new Employee();

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date date = new Date();
		date = dateformat.parse(input);

		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(date);
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(null);

		try {
            entityManager.persist(e);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ position _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	// ------------------------------------------------ Training -----------------------------------------------------

	@Test public void testTraining() throws Exception{
		
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("Motivating Techniques");
		t.setDescription("description");
		t.setDateFrom(dateFrom);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Mr.John Smith");
		t.setLocation("location");
		t.setEnrollment(250);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
			entityManager.flush();
			System.out.println("\n");
			System.out.println("------------------------------------------- Training pass ---------------------------------------");
			System.out.println("\n");

            // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			
        }

	}

	@Test public void testTrainingTitleNotBeNull () throws Exception{
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle(null);
		t.setDescription("description");
		t.setDateFrom(dateFrom);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Mr.John Smith");
		t.setLocation("location");
		t.setEnrollment(250);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ title _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }

	}

	// @Test public void testTrianingTitleSizeUnder() throws Exception {
	// 	Training t = new Training();

	// 	Admin admin = adminRepository.findByAdminId(1L);
	// 	TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
	// 	TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

	// 	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	// 	String input = "10-10-2012";
	// 	Date dateFrom = new Date();
	// 	Date dateTo = new Date();
	// 	dateFrom = dateformat.parse(input);
	// 	dateTo = dateformat.parse(input);

	// 	t.setAdmin(admin);
	// 	t.setTitle("t");
	// 	t.setDescription("description");
	// 	t.setDateFrom(dateFrom);
	// 	t.setDateTo(dateTo);
	// 	t.setTrainingType(trainingType);
	// 	t.setTrainingProgram(trainingProgram);
	// 	t.setInstructor("Mr.John Smith");
	// 	t.setLocation("location");
	// 	t.setEnrollment(250);
	// 	t.setCost(4500L);

	// 	try {
    //         entityManager.persist(t);
    //         entityManager.flush();

    //         fail("Should not pass to this line");
    //     } catch(javax.validation.ConstraintViolationException er) {
    //         Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
    //         assertEquals(violations.isEmpty(), false);
	// 		assertEquals(violations.size(), 1);
	// 		System.out.println("\n");
	// 		System.out.println("------------------------------------------- Training _ title _ found size under min ---------------------------------------");
	// 		System.out.println();
	// 		System.out.println(er.getMessage());
	// 		System.out.println("\n");
    //     }

	// }


	// @Test public void testTrainingTitleNotPattern() throws Exception {
	// 	Training t = new Training();

	// 	Admin admin = adminRepository.findByAdminId(1L);
	// 	TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
	// 	TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

	// 	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	// 	String input = "10-10-2012";
	// 	Date dateFrom = new Date();
	// 	Date dateTo = new Date();
	// 	dateFrom = dateformat.parse(input);
	// 	dateTo = dateformat.parse(input);

	// 	t.setAdmin(admin);
	// 	t.setTitle("Motivating Techniques_");
	// 	t.setDescription("description");
	// 	t.setDateFrom(dateFrom);
	// 	t.setDateTo(dateTo);
	// 	t.setTrainingType(trainingType);
	// 	t.setTrainingProgram(trainingProgram);
	// 	t.setInstructor("Mr.John Smith");
	// 	t.setLocation("location");
	// 	t.setEnrollment(250);
	// 	t.setCost(4500L);

	// 	try {
    //         entityManager.persist(t);
    //         entityManager.flush();

    //         fail("Should not pass to this line");
    //     } catch(javax.validation.ConstraintViolationException er) {
    //         Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
    //         assertEquals(violations.isEmpty(), false);
	// 		assertEquals(violations.size(), 1);
	// 		System.out.println("\n");
	// 		System.out.println("------------------------------------------- Training _ title _ found not pattern ---------------------------------------");
	// 		System.out.println();
	// 		System.out.println(er.getMessage());
	// 		System.out.println("\n");
    //     }
	// }

	//(expected=javax.persistence.PersistenceException.class) 
	// @Test
	// public void testTrainingTitleMustBeUnique() throws Exception {
		

	// 	Admin admin = adminRepository.findByAdminId(1L);
	// 	TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
	// 	TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

	// 	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	// 	String input = "10-10-2012";
	// 	Date dateFrom = new Date();
	// 	Date dateTo = new Date();
	// 	dateFrom = dateformat.parse(input);
	// 	dateTo = dateformat.parse(input);

	// 	Training t = new Training();
	// 	// t.setTrainingId(1L);
	// 	t.setAdmin(admin);
	// 	t.setTitle("title");
	// 	t.setDescription("description");
	// 	t.setDateFrom(dateFrom);
	// 	t.setDateTo(dateTo);
	// 	t.setTrainingType(trainingType);
	// 	t.setTrainingProgram(trainingProgram);
	// 	t.setInstructor("Mr.John Smith");
	// 	t.setLocation("location");
	// 	t.setEnrollment(250);
	// 	t.setCost(4500L);
	// 	entityManager.persist(t);
    //     entityManager.flush();

	// 	Training t2 = new Training();
	// 	// t2.setTrainingId(1L);
	// 	t2.setAdmin(admin);
	// 	t2.setTitle("title");
	// 	t2.setDescription("description");
	// 	t2.setDateFrom(dateFrom);
	// 	t2.setDateTo(dateTo);
	// 	t2.setTrainingType(trainingType);
	// 	t2.setTrainingProgram(trainingProgram);
	// 	t2.setInstructor("Mr.John Smith");
	// 	t2.setLocation("location");
	// 	t2.setEnrollment(250);
	// 	t2.setCost(4500L);

	// 	try {
	// 		entityManager.persist(t2);
    //         entityManager.flush();

    //         fail("Should not pass to this line");
    //     } catch(javax.persistence.PersistenceException er) {
    //         // Set<ConstraintViolation<?>> violations = er.getMessage();
    //         // assertEquals(violations.isEmpty(), false);
	// 		// assertEquals(violations.size(), 1);
	// 		System.out.println();
	// 		System.out.println();
	// 		System.out.println("-------------------------------------- found not unique -------------------------------------");
	// 		System.out.println(er+" ");
	// 		System.out.println();
	// 		System.out.println();
			
	// 	}


	// }




	@Test public void testTrainingDescriptionNotBeNull() throws Exception {
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("title");
		t.setDescription(null);
		t.setDateFrom(dateFrom);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Mr.John Smith");
		t.setLocation("location");
		t.setEnrollment(250);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ description _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testTrainingDateFromNotBeNull() throws Exception {
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("title");
		t.setDescription("description");
		t.setDateFrom(null);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Mr.John Smith");
		t.setLocation("location");
		t.setEnrollment(250);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ dateFrom _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testTrainingDateToNotBeNull() throws Exception {
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("title");
		t.setDescription("description");
		t.setDateFrom(dateFrom);
		t.setDateTo(null);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Mr.John Smith");
		t.setLocation("location");
		t.setEnrollment(250);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ dateTo _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testTrainingInstructorNotBeNull() throws Exception {
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("title");
		t.setDescription("description");
		t.setDateFrom(dateFrom);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor(null);
		t.setLocation("location");
		t.setEnrollment(250);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ instructor _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testTrainingInstructorSizeUnder() throws Exception {
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("title");
		t.setDescription("description");
		t.setDateFrom(dateFrom);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("s");
		t.setLocation("location");
		t.setEnrollment(250);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ instructor _ found size under min ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testTrainingInstructorSizeOver() throws Exception {
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("title");
		t.setDescription("description");
		t.setDateFrom(dateFrom);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Abcdeabcdeabcdeabcdeabcdeabcdea");
		t.setLocation("location");
		t.setEnrollment(250);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ instructor _ found size over max ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testTrainingInstructorNotPattern() throws Exception {
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("title");
		t.setDescription("description");
		t.setDateFrom(dateFrom);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Abcde_abcde");
		t.setLocation("location");
		t.setEnrollment(250);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ instructor _ found not pattern ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testTrainingLocationNotBeNull() throws Exception {
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("title");
		t.setDescription("description");
		t.setDateFrom(dateFrom);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Mr.John Smith");
		t.setLocation(null);
		t.setEnrollment(250);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ location _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testTrainingLocationNotPattern() throws Exception {
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("title");
		t.setDescription("description");
		t.setDateFrom(dateFrom);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Mr.John Smith");
		t.setLocation("SUT ?");
		t.setEnrollment(250);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ location _ found not pattern ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testTrainingEnrollmentNotBeNull() throws Exception {
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("title");
		t.setDescription("description");
		t.setDateFrom(dateFrom);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Mr.John Smith");
		t.setLocation("location");
		t.setEnrollment(null);
		t.setCost(4500L);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ enrollment _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

	@Test public void testTrainingCostNotBeNull() throws Exception {
		Training t = new Training();

		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		String input = "10-10-2012";
		Date dateFrom = new Date();
		Date dateTo = new Date();
		dateFrom = dateformat.parse(input);
		dateTo = dateformat.parse(input);

		t.setAdmin(admin);
		t.setTitle("title");
		t.setDescription("description");
		t.setDateFrom(dateFrom);
		t.setDateTo(dateTo);
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Mr.John Smith");
		t.setLocation("location");
		t.setEnrollment(250);
		t.setCost(null);

		try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ cost _ found null ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
		}
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
	@Test
    public void testTicketNormal() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("pan");
        t.setPhoneNumber("0912341234");
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(admin);

		try{
            entityManager.persist(t);
			entityManager.flush();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------TTicket est Pass---------------------------");
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
    public void testTicketNameCanNotBeNull() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName(null);
        t.setPhoneNumber("0912341234");
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

			fail("Ticket name must be valid");
			
        } catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Name Not Null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
	public void testTicketNameTooShortLength() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("t");
        t.setPhoneNumber("0912341234");
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Ticket name out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Name Short---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	
	@Test
	public void testTicketNameTooLongLength() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("wwwwwwwwwwwwwwwwwwwwwwwt");
        t.setPhoneNumber("0912341234");
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("ticket name out of length");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Name Long---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
	public void testTicketNameWrongPattern() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("Panja1");
        t.setPhoneNumber("0912341234");
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Ticket name wrong Pattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Name Wrong Pattern---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
@Test
    public void testTicketPhoneNumberCanNotBeNull() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("Pan");
        t.setPhoneNumber(null);
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Ticket phone number must be valid(null)");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Phone Number Not Null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	
	@Test
    public void testTicketPhoneNumberInvalidPattern() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("Pan");
        t.setPhoneNumber("5689987654");
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Ticket phone number must be valid(pattern)");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Phone Number is Not Pattern---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	
	@Test
    public void testTicketPhoneNumberTooShort() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("Pan");
        t.setPhoneNumber("089987654");
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Ticket phone number too short");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Phone Number Too Short---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
    public void testTicketPhoneNumberTooLong() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("Pan");
        t.setPhoneNumber("09689987654");
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Ticket phone number too long");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Phone Number Too Long---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	@Test
    public void testTicketTypeCanBeNotNull() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("Pan");
        t.setPhoneNumber("0689987654");
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(null);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Ticket Type must be not null");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Type Cannot Be Null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}

	@Test
    public void testTicketFieldCanBeNotNull() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("Pan");
        t.setPhoneNumber("0689987654");
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(null);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Ticket Field must be not null");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Field Cannot Be Null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
    public void testTicketAdminCanBeNotNull() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("Pan");
        t.setPhoneNumber("0689987654");
		t.setDate(new Date());
		t.setTime(LocalTime.now());
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(null);


        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Ticket Admin must be not null");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Admin Cannot Be Null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test(expected=javax.persistence.PersistenceException.class)
    public void testTicketIdMustBeUnique() {
		
        Ticket t1 = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		t1.setTicketId(1L);
        t1.setName("Pan");
        t1.setPhoneNumber("0689987654");
		t1.setDate(new Date());
		t1.setTime(LocalTime.now());
		t1.setTicketType(ticketType);
		t1.setField(field);
		t1.setAdmin(admin);

		entityManager.persist(t1);
		entityManager.flush();

        Ticket t2 = new Ticket();
        Admin admin1 = adminRepository.findByAdminId(1L);
		Field field1 = fieldRepository.findByFieldId(1L);
		TicketType ticketType1 = ticketTypeRepository.findByTicketTypeId(1L);

		t2.setTicketId(1L);
        t2.setName("Tan");
        t2.setPhoneNumber("0689987654");
		t2.setDate(new Date());
		t2.setTime(LocalTime.now());
		t2.setTicketType(ticketType1);
		t2.setField(field1);
		t2.setAdmin(admin1);

		try{

		entityManager.persist(t2);
			entityManager.flush();
			
            fail("Ticket Not Unique");
		} catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Unique---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e);
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
	}
