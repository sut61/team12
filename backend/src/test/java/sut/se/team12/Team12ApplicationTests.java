package sut.se.team12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
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



}