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
public class FieldOrderTest {

	@Autowired private AdminRepository adminRepository;
	@Autowired private MemberRepository memberRepository;

	@Autowired private FieldRepository fieldRepository;
	@Autowired private FieldDurationRepository fieldDurationRepository;

	
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
	f.setDate(new Date());


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
		f.setDate(new Date());

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
		f.setDate(new Date());
	
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
		f.setNote("a");
		f.setDate(new Date());
	
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
		f.setNote("aaaaaaaaaaddddddddddffffffffff");
		f.setDate(new Date());

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
//ทดสอบ Date ห้ามว่าง
@Test
public void testFieldDateCannotBeNull() {
	FieldOrder f = new FieldOrder();
	Admin _admin = adminRepository.findByAdminId(1L);
	Member _member = memberRepository.findByMemberId(1L);
	Field _field = fieldRepository.findByFieldId(1L);
	FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);

		f.setAdmin(_admin);
		f.setMember(_member);
		f.setField(_field);
		f.setFieldDuration(_fieldDuration);
		f.setNote("HelloWorld");
		f.setDate(null);

		try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("-----------------------------------> FieldOrder Date NotNull <--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
}
//ทดสอบ Select Admin ห้ามว่าง
@Test
public void testFieldAdminCannotBeNull() {
	FieldOrder f = new FieldOrder();
	Admin _admin = adminRepository.findByAdminId(1L);
	Member _member = memberRepository.findByMemberId(1L);
	Field _field = fieldRepository.findByFieldId(1L);
	FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);

		f.setAdmin(null);
		f.setMember(_member);
		f.setField(_field);
		f.setFieldDuration(_fieldDuration);
		f.setNote("HelloWorld");
		f.setDate(new Date());

		try {
            entityManager.persist(f);
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
public void testFieldMemberCannotBeNull() {
	FieldOrder f = new FieldOrder();
	Admin _admin = adminRepository.findByAdminId(1L);
	Member _member = memberRepository.findByMemberId(1L);
	Field _field = fieldRepository.findByFieldId(1L);
	FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);

		f.setAdmin(_admin);
		f.setMember(null);
		f.setField(_field);
		f.setFieldDuration(_fieldDuration);
		f.setNote("HelloWorld");
		f.setDate(new Date());

		try {
            entityManager.persist(f);
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
//ทดสอบ Select Field ห้ามว่าง
@Test
public void testFieldFieldCannotBeNull() {
	FieldOrder f = new FieldOrder();
	Admin _admin = adminRepository.findByAdminId(1L);
	Member _member = memberRepository.findByMemberId(1L);
	Field _field = fieldRepository.findByFieldId(1L);
	FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);

		f.setAdmin(_admin);
		f.setMember(_member);
		f.setField(null);
		f.setFieldDuration(_fieldDuration);
		f.setNote("HelloWorld");
		f.setDate(new Date());

		try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("-----------------------------------> Field NotNull <--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
}

//ทดสอบ Select FieldDuration ห้ามว่าง
@Test
public void testFieldFieldDurationCannotBeNull() {
	FieldOrder f = new FieldOrder();
	Admin _admin = adminRepository.findByAdminId(1L);
	Member _member = memberRepository.findByMemberId(1L);
	Field _field = fieldRepository.findByFieldId(1L);
	FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);

		f.setAdmin(_admin);
		f.setMember(_member);
		f.setField(_field);
		f.setFieldDuration(null);
		f.setNote("HelloWorld");
		f.setDate(new Date());

		try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("-----------------------------------> FieldDuration NotNull <--------------------------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
        }
	}
	

// ทดสอบ unique Id FieldOrderId

@Test(expected=javax.persistence.PersistenceException.class) 
	public void testFieldOrderIdMustBeUnique(){
		
		Admin _admin = adminRepository.findByAdminId(1L);
		Member _member = memberRepository.findByMemberId(1L);
		Field _field = fieldRepository.findByFieldId(1L);
		FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);

		FieldOrder f = new FieldOrder();
		f.setFieldOrderId(1L);
		f.setAdmin(_admin);
		f.setMember(_member);
		f.setField(_field);
		f.setFieldDuration(_fieldDuration);
		f.setNote("Sasiprapha");
		f.setDate(new Date());
		entityManager.persist(f);
		entityManager.flush();

		FieldOrder f1 = new FieldOrder();
		f1.setFieldOrderId(1L);
		f1.setAdmin(_admin);
		f1.setMember(_member);
		f1.setField(_field);
		f1.setFieldDuration(_fieldDuration);
		f1.setNote("Sasiprapha");
		f1.setDate(new Date());

		try {
            entityManager.persist(f1);
			entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException er) {
            Set<ConstraintViolation<?>> violations = er.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("\n");
			System.out.println("------------------------------------------- FieldOrder _ id _ found not unique ---------------------------------------");
			System.out.println();
			System.out.println(er.getMessage());
			System.out.println("\n");
        }
	}

// ทดสอบ NotNull Id FieldOrderId
	// @Test
	// public void testFieldFieldOrderIdCannotBeNull(){
	// 	FieldOrder f = new FieldOrder();
	// 	Admin _admin = adminRepository.findByAdminId(1L);
	// 	Member _member = memberRepository.findByMemberId(1L);
	// 	Field _field = fieldRepository.findByFieldId(1L);
	// 	FieldDuration _fieldDuration = fieldDurationRepository.findByFieldDurationId(1L);
	
	// 	f.setFieldOrderId(null);
	// 	f.setAdmin(_admin);
	// 	f.setMember(_member);
	// 	f.setField(_field);
	// 	f.setFieldDuration(_fieldDuration);
	// 	f.setNote("Sasiprapha");
	// 	f.setDate(new Date());
	
	
	// 	try {
    //         entityManager.persist(f);
    //         entityManager.flush();

    //         fail("Should not pass to this line");
    //     } catch(javax.validation.ConstraintViolationException e) {
    //         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
    //         assertEquals(violations.isEmpty(), false);
	// 		assertEquals(violations.size(), 1);
	// 		System.out.println();
	// 		System.out.println("-----------------------------------> FieldOrder _ id _ found not NotNull <--------------------------------------");
	// 		System.out.println(e.getMessage());
	// 		System.out.println();
	// 		System.out.println();
    //     }
	// }


}