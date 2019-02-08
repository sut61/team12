package sut.se.team12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
@DataJpaTest
public class RoomTests {
	
    @Autowired private RoomCancelOrderRepository roomCancelOrderRepository;
    @Autowired private TestEntityManager entityManager;
	@Autowired private AdminRepository adminRepository;
	@Autowired private RoomStatusRepository roomStatusRepository;
    @Autowired private RoomRepository roomRepository;
    @Autowired private MemberRepository memberRepository;
    @Autowired private RoomDurationRepository roomDurationRepository;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    //-------------------------------------Sprint1-testMemberCannotBeNull----------------------------
    @Test
	public void testMemberCannotBeNull() {
		RoomOrder r = new RoomOrder();
		

		Admin admin1 = adminRepository.findByAdminId(1L);
        Room room01 = roomRepository.findByRoomId(1L);
        Member member1 = memberRepository.findByMemberId(1L);
        RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);


		r.setRoom(room01);
        r.setAdmin(admin1);
        r.setRoomDuration(roomDuration01);
        r.setMember(null);
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
            System.out.println("Member is not null");
            System.out.println(e.getMessage());
            System.out.println();
		}
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
    

}

