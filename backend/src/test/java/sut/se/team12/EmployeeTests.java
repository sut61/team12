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
public class EmployeeTests {

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

	@Test public void testEmployeeIdMustBeUnique(){
		

		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

		Employee e = new Employee();
		e.setEmployeeId(1L);
		e.setAdmin(admin);
		e.setId("1234567890123");
		e.setTitle(title);
		e.setFirstName("Supanniga");
		e.setLastName("Ogasawara");
		e.setBirthDate(new Date());
		e.setPhone("0812345678");
		e.setEmail("supanniga@gmail.com");
		e.setAddress("11 SUT");
		e.setDegree(degree);
		e.setPosition(position);
		entityManager.persist(e);
		entityManager.flush();

		Employee e2 = new Employee();
		e2.setEmployeeId(1L);
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

		try {
            entityManager.persist(e2);
			entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Employee _ id _ found not unique ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
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

	
	@Test(expected=javax.persistence.PersistenceException.class)
    public void testIdMustBeUnique(){
        
		Admin admin = adminRepository.findByAdminId(1L);
		Title title = titleRepository.findByTitleId(1L);
		Degree degree = degreeRepositiry.findByDegreeId(1L);
		Position position = positionRepository.findByPositionId(1L);

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
		}catch(javax.validation.ConstraintViolationException er){
			Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
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
}