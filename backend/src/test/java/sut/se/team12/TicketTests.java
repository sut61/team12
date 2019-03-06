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

	@Autowired private AdminRepository adminRepository;
	@Autowired private FieldRepository fieldRepository;
	@Autowired private TicketRepository ticketRepository;
	@Autowired private TicketTypeRepository ticketTypeRepository;
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
			System.out.println("---------------------Ticket Test Pass---------------------------");
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
    @Test
    public void testTicketDateCanNotBeNull() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("panpan");
        t.setPhoneNumber("0912341234");
		t.setDate(null);
		t.setTime(LocalTime.now());
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

			fail("Ticket date must be valid");
			
        } catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Date Not Null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	@Test
    public void testTicketTimeCanNotBeNull() {
		Ticket t = new Ticket();
		Admin admin = adminRepository.findByAdminId(1L);
		Field field = fieldRepository.findByFieldId(1L);
		TicketType ticketType = ticketTypeRepository.findByTicketTypeId(1L);

		// t.setTicketId(1L);
        t.setName("panpan");
        t.setPhoneNumber("0912341234");
		t.setDate(new Date());
		t.setTime(null);
		t.setTicketType(ticketType);
		t.setField(field);
		t.setAdmin(admin);


        try {
            entityManager.persist(t);
            entityManager.flush();

			fail("Ticket Time must be valid");
			
        } catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Ticket Time Not Null---------------------------");
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
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
    public void testTicketTypeIdMustBeUnique() {
        
        TicketType t = new TicketType();
    
        t.setTicketTypeId(1L);
        t.setTicketType("adult");
        t.setPrice(20.00);
    
        entityManager.persist(t);
        entityManager.flush();
    
        TicketType t1 = new TicketType();
    
        t1.setTicketTypeId(1L);
        t1.setTicketType("kids");
        t1.setPrice(21.00);
    
        try {
            entityManager.persist(t1);
            entityManager.flush();
    
            fail("TicketType Id not unique");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------TicketType Id Unique---------------------------");
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    
    }
    @Test
        public void testTicketTypeCannotBeNull() {
            TicketType t = new TicketType();
            t.setTicketType(null);
            t.setPrice(20.00);
    
            try {
                entityManager.persist(t);
                entityManager.flush();
    
                fail("TicketType TicketType must not be null to be valid");
            } catch(javax.validation.ConstraintViolationException e) {
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("---------------------TicketType TicketType not be null---------------------------");
                System.out.println();
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
                System.out.println();
            }
    }
    @Test
        public void testTicketTypePriceCannotBeNull() {
            TicketType t = new TicketType();
            t.setTicketType("VIP");
            t.setPrice(null);
    
            try {
                entityManager.persist(t);
                entityManager.flush();
    
                fail("TicketType Price must not be null to be valid");
            } catch(javax.validation.ConstraintViolationException e) {
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("---------------------TicketType Price not be null---------------------------");
                System.out.println();
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
                System.out.println();
            }
    }
	@Test(expected=javax.persistence.PersistenceException.class)
    public void testFieldIdMustBeUnique() {
        
        Field f = new Field();
    
        f.setFieldId(1L);
        f.setFieldName("football");
    
        entityManager.persist(f);
        entityManager.flush();
    
        Field f1 = new Field();
    
        f1.setFieldId(1L);
        f1.setFieldName("basketball");
    
        try {
            entityManager.persist(f1);
            entityManager.flush();
    
            fail("Field Id not unique");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------Field Id Unique---------------------------");
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    
    }
    @Test
        public void testFieldNameCannotBeNull() {
            Field f = new Field();
            f.setFieldName(null);
    
            try {
                entityManager.persist(f);
                entityManager.flush();
    
                fail("Field FieldName must not be null to be valid");
            } catch(javax.validation.ConstraintViolationException e) {
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("---------------------Field FieldName not be null---------------------------");
                System.out.println();
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
                System.out.println();
            }
    }
    @Test
    public void testTicketTypeNormal() {
		TicketType t = new TicketType();

        t.setTicketType("Adult");
        t.setPrice(20.00);

		try{
            entityManager.persist(t);
			entityManager.flush();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------TicketType Test Pass---------------------------");
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
    public void testFieldNormal() {
		Field f = new Field();

        f.setFieldName("football");


		try{
            entityManager.persist(f);
			entityManager.flush();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------Field Test Pass---------------------------");
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
}