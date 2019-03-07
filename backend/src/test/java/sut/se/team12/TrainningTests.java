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
public class TrainningTests {

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

	@Test(expected=javax.persistence.PersistenceException.class)
	public void testTrainingIdMustBeUnique(){
		
		Admin admin = adminRepository.findByAdminId(1L);
		TrainingType  trainingType = trainingTypeRepository.findByTypeId(1L);
		TrainingProgram trainingProgram = trainingProgramRepository.findByProgramId(1L);

		Training t = new Training();
		t.setTrainingId(1L);
		t.setAdmin(admin);
		t.setTitle("Motivating Techniques");
		t.setDescription("description");
		t.setDateFrom(new Date());
		t.setDateTo(new Date());
		t.setTrainingType(trainingType);
		t.setTrainingProgram(trainingProgram);
		t.setInstructor("Mr.John Smith");
		t.setLocation("location");
		t.setEnrollment(250);
		t.setCost(4500L);
		entityManager.persist(t);
		entityManager.flush();

		Training t2 = new Training();
		t2.setTrainingId(1L);
		t2.setAdmin(admin);
		t2.setTitle("Motivating Techniques");
		t2.setDescription("description");
		t2.setDateFrom(new Date());
		t2.setDateTo(new Date());
		t2.setTrainingType(trainingType);
		t2.setTrainingProgram(trainingProgram);
		t2.setInstructor("Mr.John Smith");
		t2.setLocation("location");
		t2.setEnrollment(250);
		t2.setCost(4500L);

		try {
            entityManager.persist(t2);
			entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- Training _ id _ found not unique ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
			
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
}