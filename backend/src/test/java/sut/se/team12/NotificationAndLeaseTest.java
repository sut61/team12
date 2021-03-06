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
public class NotificationAndLeaseTest {

	@Autowired private AdminRepository adminRepository;
	@Autowired private MemberRepository memberRepository;
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private FieldRepository fieldRepository;
	@Autowired private LeaseDurationRepository leaseDurationRepository;
	@Autowired private LeaseAccessoryRepository leaseAccessoryRepository;

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

    	//--------------------------------------------------------------------------------------------------------------//
	//--------------------------------------------------> " Lease " <----------------------------------------------//
	//------------------------------------------------------------------------------------------------------------//
	@Test 
	public void testLease(){
		Lease lease1 = new Lease();
		Admin admin1 = adminRepository.findByAdminId(1L);
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setAdmin(admin1);
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
	public void testLeaseAdminCannotBeNull(){
		Lease lease1 = new Lease();
		Admin admin1 = adminRepository.findByAdminId(1L);
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setAdmin(null);
		lease1.setMember(member1);
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
			System.out.println("----------------------------------->Admin NotNull<--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }

	}

	@Test 
	public void testLeaseMemberCannotBeNull(){
		Lease lease1 = new Lease();
		Admin admin1 = adminRepository.findByAdminId(1L);
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setAdmin(admin1);
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
		Admin admin1 = adminRepository.findByAdminId(1L);
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setAdmin(admin1);
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
		Admin admin1 = adminRepository.findByAdminId(1L);
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setAdmin(admin1);
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
		Admin admin1 = adminRepository.findByAdminId(1L);
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setAdmin(admin1);
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
		Admin admin1 = adminRepository.findByAdminId(1L);
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setAdmin(admin1);
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
		Admin admin1 = adminRepository.findByAdminId(1L);
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setAdmin(admin1);
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
		Admin admin1 = adminRepository.findByAdminId(1L);
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setAdmin(admin1);
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
	
	@Test(expected=javax.persistence.PersistenceException.class)
	
    public void testLeaseIdMustBeUnique() {
		
        Lease lease1 = new Lease();
		Admin admin1 = adminRepository.findByAdminId(1L);
		Member member1 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory1 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration1 = leaseDurationRepository.findByDurationId(1L);

		lease1.setAdmin(admin1);
		lease1.setLeaseId(1L);
        lease1.setMember(member1);
		lease1.setAccessory(accessory1);
		lease1.setDuration(duration1);
		lease1.setNote("------");

		entityManager.persist(lease1);
		entityManager.flush();

		Lease lease2 = new Lease();
		Admin admin2 = adminRepository.findByAdminId(1L);
		Member member2 = memberRepository.findByMemberId(1L);
		LeaseAccessory accessory2 = leaseAccessoryRepository.findByAccessoryId(1L);
		LeaseDuration duration2 = leaseDurationRepository.findByDurationId(1L);

		lease2.setLeaseId(1L);
		lease1.setAdmin(admin2);
     	lease2.setMember(member2);
		lease2.setAccessory(accessory2);
		lease2.setDuration(duration2);
		lease2.setNote("------");

		try{

		entityManager.persist(lease2);
			entityManager.flush();
			
            fail("Lease Not Unique");
		} catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Lease Unique---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e);
			System.out.println();
			System.out.println();
		}
	}

	// //-----------------------------------------------------------------------------------------------------------------//
	// //-----------------------------------------------------> " Notification " <---------------------------------------------------//
	// //-----------------------------------------------------------------------------------------------------------------//
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
	
	@Test(expected=javax.persistence.PersistenceException.class)
	
    public void testNotificationIdMustBeUnique() {
		
        Notification notification1 = new Notification();

		Admin admin1 = adminRepository.findByAdminId(1L);
		Employee employee1 = employeeRepository.findByEmployeeId(2L);
		Field Field1 = fieldRepository.findByFieldId(1L);

		notification1.setNotificationId(1L);
		notification1.setAdmin(admin1);
		notification1.setEmployee(employee1);
		notification1.setField(Field1);
		notification1.setNote("------");

		entityManager.persist(notification1);
		entityManager.flush();

		Notification notification2 = new Notification();

		Admin admin2 = adminRepository.findByAdminId(1L);
		Employee employee2 = employeeRepository.findByEmployeeId(2L);
		Field Field2 = fieldRepository.findByFieldId(1L);

		notification2.setNotificationId(1L);
		notification2.setAdmin(admin2);
		notification2.setEmployee(employee2);
		notification2.setField(Field2);
		notification2.setNote("------");

		try{

		entityManager.persist(notification2);
			entityManager.flush();
			
            fail("Notification Not Unique");
		} catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Lease Unique---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e);
			System.out.println();
			System.out.println();
		}
	}

}