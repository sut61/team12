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
public class TicketTests {

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
	
}