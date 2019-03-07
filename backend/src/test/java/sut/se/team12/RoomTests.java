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
    
    @Autowired private RoomOrderRepository roomOrderRepository;
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
     //-------------------------------------Sprint1-testEverythingIsOK----------------------------
     @Test
     public void testFirstSprintIsOK() {
         RoomOrder r = new RoomOrder();
         
 
         Admin admin1 = adminRepository.findByAdminId(1L);
         Room room01 = roomRepository.findByRoomId(1L);
         Member member1 = memberRepository.findByMemberId(1L);
         RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
         RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);
 
         r.setRoomStatus(roomStatus);
         r.setRoom(room01);
         r.setAdmin(admin1);
         r.setRoomDuration(roomDuration01);
         r.setMember(member1);
         r.setNotee("notee");
         r.setDate(new Date());
 
         try {
             entityManager.persist(r);
             entityManager.flush();
             System.out.println();
             System.out.println();
             System.out.println("-------------------------------------Sprint1-testEverythingIsOK----------------------------");
             System.out.println();
             System.out.println();
 
            // fail("Should not pass to this line");
         } catch(javax.validation.ConstraintViolationException e) {
             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
             assertEquals(violations.isEmpty(), false);
             assertEquals(violations.size(), 1);
         }
     }
    //-------------------------------------Sprint1-testNoteCannotBeNull----------------------------
	@Test
	public void testNoteeCannotBeNull() {
        RoomOrder r = new RoomOrder();
         
 
        Admin admin1 = adminRepository.findByAdminId(1L);
        Room room01 = roomRepository.findByRoomId(1L);
        Member member1 = memberRepository.findByMemberId(1L);
        RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
        RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);
 
        r.setRoomStatus(roomStatus);
        r.setRoom(room01);
        r.setAdmin(admin1);
        r.setRoomDuration(roomDuration01);
        r.setMember(member1);
        r.setNotee(null);
        r.setDate(new Date());

        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------Sprint1-testNoteCannotBeNull----------------------------");
            System.out.println(e.getMessage());
            System.out.println();
		}
    }
     //--------------------------------------Sprint1-testNoteAerTooLong------------------------------------------
     @Test
     public void testNoteeAerTooLong() {
        RoomOrder r = new RoomOrder();
         
 
        Admin admin1 = adminRepository.findByAdminId(1L);
        Room room01 = roomRepository.findByRoomId(1L);
        Member member1 = memberRepository.findByMemberId(1L);
        RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
        RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);
 
        r.setRoomStatus(roomStatus);
        r.setRoom(room01);
        r.setAdmin(admin1);
        r.setRoomDuration(roomDuration01);
        r.setMember(member1);
        r.setNotee("nnnnnnooooootttttteeeeeennnnnnoooooo");
        r.setDate(new Date());

 
         try {
             entityManager.persist(r);
             entityManager.flush();
 
             fail("Should not pass to this line");
         } catch(javax.validation.ConstraintViolationException e) {
             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
             assertEquals(violations.isEmpty(), false);
             assertEquals(violations.size(), 1);
             System.out.println();
             System.out.println();
             System.out.println("--------------------------------------Sprint1-testNoteAerTooLong------------------------------------------");
             System.out.println(e.getMessage());
             System.out.println();
         }
     }
     //--------------------------------------Sprint1-testNoteAerTooShort------------------------------------------
     @Test
     public void testNoteeAerTooShort() {
        RoomOrder r = new RoomOrder();
         
 
        Admin admin1 = adminRepository.findByAdminId(1L);
        Room room01 = roomRepository.findByRoomId(1L);
        Member member1 = memberRepository.findByMemberId(1L);
        RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
        RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);
 
        r.setRoomStatus(roomStatus);
        r.setRoom(room01);
        r.setAdmin(admin1);
        r.setRoomDuration(roomDuration01);
        r.setMember(member1);
        r.setNotee("note");
        r.setDate(new Date());

 
         try {
             entityManager.persist(r);
             entityManager.flush();
 
             fail("Should not pass to this line");
         } catch(javax.validation.ConstraintViolationException e) {
             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
             assertEquals(violations.isEmpty(), false);
             assertEquals(violations.size(), 1);
             System.out.println();
             System.out.println();
             System.out.println("--------------------------------------Sprint1-testNoteAerTooShort------------------------------------------");
             System.out.println(e.getMessage());
             System.out.println();
         }
     }
      //-------------------------------Sprint1-testNotePatternIsWrong---------------------------------------
      @Test
      public void testNoteePatternIsWrong() {
        RoomOrder r = new RoomOrder();
         
 
        Admin admin1 = adminRepository.findByAdminId(1L);
        Room room01 = roomRepository.findByRoomId(1L);
        Member member1 = memberRepository.findByMemberId(1L);
        RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
        RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);
 
        r.setRoomStatus(roomStatus);
        r.setRoom(room01);
        r.setAdmin(admin1);
        r.setRoomDuration(roomDuration01);
        r.setMember(member1);
        r.setNotee("-------");
        r.setDate(new Date());
  
          try {
              entityManager.persist(r);
              entityManager.flush();
  
              fail("Should not pass to this line");
          } catch(javax.validation.ConstraintViolationException e) {
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(),1);
              System.out.println();
              System.out.println();
              System.out.println("-------------------------------Sprint1-testNotePatternIsWrong---------------------------------------");
              System.out.println(e.getMessage());
              System.out.println();
          }
      }
    //-------------------------------------Sprint1-testMemberCannotBeNull----------------------------
    @Test
	public void testMemberCannotBeNull() {
		RoomOrder r = new RoomOrder();
		

		Admin admin1 = adminRepository.findByAdminId(1L);
        Room room01 = roomRepository.findByRoomId(1L);
       // Member member1 = memberRepository.findByMemberId(1L);
        RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
        RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);
 
        r.setRoomStatus(roomStatus);
		r.setRoom(room01);
        r.setAdmin(admin1);
        r.setRoomDuration(roomDuration01);
        r.setMember(null);
        r.setNotee("notee");
		r.setDate(new Date());

        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------Sprint1-testMemberCannotBeNull----------------------------");
            System.out.println(e.getMessage());
            System.out.println();
		}
    }
      //-------------------------------------Sprint1-testRoomCannotBeNull----------------------------
      @Test
      public void testRoomCannotBeNull() {
        RoomOrder r = new RoomOrder();
		

		Admin admin1 = adminRepository.findByAdminId(1L);
       // Room room01 = roomRepository.findByRoomId(1L);
        Member member1 = memberRepository.findByMemberId(1L);
        RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
        RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);
 
        r.setRoomStatus(roomStatus);
		r.setRoom(null);
        r.setAdmin(admin1);
        r.setRoomDuration(roomDuration01);
        r.setMember(member1);
        r.setNotee("notee");
		r.setDate(new Date());

        try {
            entityManager.persist(r);
            entityManager.flush();
           fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(),1);
            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------Sprint1-testRoomCannotBeNull----------------------------");
            System.out.println(e.getMessage());
            System.out.println();
		}
    }
     //-------------------------------------Sprint1-testStatusCannotBeNull----------------------------
     @Test
     public void testStatusCannotBeNull() {
       RoomOrder r = new RoomOrder();
       

       Admin admin1 = adminRepository.findByAdminId(1L);
       Room room01 = roomRepository.findByRoomId(1L);
       Member member1 = memberRepository.findByMemberId(1L);
       RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
       //RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);

       r.setRoomStatus(null);
       r.setRoom(room01);
       r.setAdmin(admin1);
       r.setRoomDuration(roomDuration01);
       r.setMember(member1);
       r.setNotee("notee");
       r.setDate(new Date());

       try {
           entityManager.persist(r);
           entityManager.flush();
          fail("Should not pass to this line");
       } catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(),1);
           System.out.println();
           System.out.println();
           System.out.println("-------------------------------------Sprint1-testStatusCannotBeNull----------------------------");
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
      //RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
      RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);
 
      r.setRoomStatus(roomStatus);
      r.setRoom(room01);
      r.setAdmin(admin1);
      r.setRoomDuration(null);
      r.setMember(member1);
      r.setNotee("notee");
      r.setDate(new Date());

      try {
          entityManager.persist(r);
          entityManager.flush();

          fail("Should not pass to this line");
      } catch(javax.validation.ConstraintViolationException e) {
          Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
          assertEquals(violations.isEmpty(), false);
          assertEquals(violations.size(), 1);
          System.out.println();
          System.out.println();
          System.out.println("-------------------------------------Sprint1-testRoomDurationCannotBeNull----------------------------");
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
     RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);
 
     r.setRoomStatus(roomStatus);
     r.setRoom(room01);
     r.setAdmin(admin1);
     r.setRoomDuration(roomDuration01);
     r.setMember(member1);
     r.setNotee("notee");
     r.setDate(null);

     try {
         entityManager.persist(r);
         entityManager.flush();

         fail("Should not pass to this line");
     } catch(javax.validation.ConstraintViolationException e) {
         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
         assertEquals(violations.isEmpty(), false);
         assertEquals(violations.size(), 1);
         System.out.println();
         System.out.println();
         System.out.println("-------------------------------------Sprint1-testDateCannotBeNull----------------------------");
         System.out.println(e.getMessage());
         System.out.println();
     }
 }
    //-------------------------------------Sprint1-testRAdminCannotBeNull----------------------------
    @Test
    public void testRAdminCannotBeNull() {
      RoomOrder r = new RoomOrder();
      
 
      Admin admin1 = adminRepository.findByAdminId(1L);
      Room room01 = roomRepository.findByRoomId(1L);
      Member member1 = memberRepository.findByMemberId(1L);
      RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
      RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);

      r.setRoomStatus(roomStatus);
      r.setRoom(room01);
      r.setAdmin(null);
      r.setRoomDuration(roomDuration01);
      r.setMember(member1);
      r.setNotee("notee");
      r.setDate(new Date());
 
      try {
          entityManager.persist(r);
          entityManager.flush();
 
          fail("Should not pass to this line");
      } catch(javax.validation.ConstraintViolationException e) {
          Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
          assertEquals(violations.isEmpty(), false);
          assertEquals(violations.size(), 1);
          System.out.println();
          System.out.println();
          System.out.println("-------------------------------------Sprint1-testRAdminCannotBeNull----------------------------");
          System.out.println(e.getMessage());
          System.out.println();
      }
  }
 //----------------------------------------sprint1-testRoomOrderIDMustBeUnique--------------------------------------------------
 @Test(expected=javax.persistence.PersistenceException.class)
 public void testRoomMustBeUnique() {
    RoomOrder r = new RoomOrder();
     
    //RoomOrder roomOrder = roomOrderRepository.findByRoomOrderId(1L);
    Admin admin1 = adminRepository.findByAdminId(1L);
    Room room01 = roomRepository.findByRoomId(1L);
    Member member1 = memberRepository.findByMemberId(1L);
    RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
    RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);
 
    r.setRoomStatus(roomStatus);
    r.setRoomOrderId(1L);
    r.setRoom(room01);
    r.setAdmin(admin1);
    r.setRoomDuration(roomDuration01);
    r.setMember(member1);
    r.setNotee("notee");
    r.setDate(new Date());


     entityManager.persist(r);
     entityManager.flush();

     RoomOrder r1 = new RoomOrder();
     
    // RoomOrder roomOrder1 = roomOrderRepository.findByRoomOrderId(1L);
     Admin admin = adminRepository.findByAdminId(1L);
     Room room = roomRepository.findByRoomId(1L);
     Member member = memberRepository.findByMemberId(1L);
     RoomDuration roomDuration = roomDurationRepository.findByroomDurationId(1L);
     RoomStatus roomStatus1 = roomStatusRepository.findByroomStatusId(1L);
 
     r1.setRoomStatus(roomStatus1);
     r1.setRoomOrderId(1L);
     r1.setRoom(room);
     r1.setAdmin(admin);
     r1.setRoomDuration(roomDuration);
     r1.setMember(member);
     r1.setNotee("notee");
     r1.setDate(new Date());


     try {
         entityManager.persist(r1);
         entityManager.flush();

         fail("ID is not unique");
     } catch(javax.validation.ConstraintViolationException e) {
         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
         assertEquals(violations.isEmpty(), false);
         assertEquals(violations.size(), 1);
         System.out.println();
         System.out.println();
         System.out.println("----------------------------------------sprint1-testRoomOrderIDMustBeUnique--------------------------------------------------");
         System.out.println();
         System.out.println();
         System.out.println(e.getMessage());
         System.out.println();
     }

 }
 //----------------------------------------sprint1-testNoteeIDMustBeUnique--------------------------------------------------
 @Test(expected=javax.persistence.PersistenceException.class)
 public void testNoteeIDMustBeUnique() {
    RoomOrder r = new RoomOrder();
     
    //RoomOrder roomOrder = roomOrderRepository.findByRoomOrderId(1L);
    Admin admin1 = adminRepository.findByAdminId(1L);
    Room room01 = roomRepository.findByRoomId(1L);
    Member member1 = memberRepository.findByMemberId(1L);
    RoomDuration roomDuration01 = roomDurationRepository.findByroomDurationId(1L);
    RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);
 
    r.setRoomStatus(roomStatus);
    r.setRoomOrderId(1L);
    r.setRoom(room01);
    r.setAdmin(admin1);
    r.setRoomDuration(roomDuration01);
    r.setMember(member1);
    r.setNotee("notee");
    r.setDate(new Date());


     entityManager.persist(r);
     entityManager.flush();

     RoomOrder r1 = new RoomOrder();
     
    // RoomOrder roomOrder1 = roomOrderRepository.findByRoomOrderId(1L);
     Admin admin = adminRepository.findByAdminId(1L);
     Room room = roomRepository.findByRoomId(1L);
     Member member = memberRepository.findByMemberId(1L);
     RoomDuration roomDuration = roomDurationRepository.findByroomDurationId(1L);
     RoomStatus roomStatus1 = roomStatusRepository.findByroomStatusId(1L);
 
     r1.setRoomStatus(roomStatus1);
     r1.setRoomOrderId(1L);
     r1.setRoom(room);
     r1.setAdmin(admin);
     r1.setRoomDuration(roomDuration);
     r1.setMember(member);
     r1.setNotee("notee");
     r1.setDate(new Date());


     try {
         entityManager.persist(r1);
         entityManager.flush();

         fail("ID is not unique");
     } catch(javax.validation.ConstraintViolationException e) {
         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
         assertEquals(violations.isEmpty(), false);
         assertEquals(violations.size(), 1);
         System.out.println();
         System.out.println();
         System.out.println("----------------------------------------sprint1-testNoteeIDMustBeUnique--------------------------------------------------");
         System.out.println();
         System.out.println();
         System.out.println(e.getMessage());
         System.out.println();
     }

 }
    //--------------------------------------Sprint2-testEvethingIsOK----------------------------
	@Test
	public void testSecondSprintIsOK() {
		RoomCancelOrder r = new RoomCancelOrder();
		

		Admin admin1 = adminRepository.findByAdminId(1L);
		RoomStatus roomStatus02 = roomStatusRepository.findByroomStatusId(1L);
        RoomOrder roomOrder = roomOrderRepository.findByRoomOrderId(1L);
 
        r.setRoomOrder(roomOrder);
		r.setNote("notee");
		r.setAdmin(admin1);
		r.setRoomStatus(roomStatus02);
		r.setDate(new Date());

        try {
            entityManager.persist(r);
            entityManager.flush();
            System.out.println();
            System.out.println(" //--------------------------------------Sprint2-testEvethingIsOK----------------------------");
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
        RoomOrder roomOrder = roomOrderRepository.findByRoomOrderId(1L);
 
        r.setRoomOrder(roomOrder);
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
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println("	//-------------------------------------Sprint2-testNoteCannotBeNull----------------------------");
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
        RoomOrder roomOrder = roomOrderRepository.findByRoomOrderId(1L);
 
        r.setRoomOrder(roomOrder);
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
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println(" //--------------------------------------Sprint2-testNoteAerTooLong------------------------------------------ ");
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
        RoomOrder roomOrder = roomOrderRepository.findByRoomOrderId(1L);
 
        r.setRoomOrder(roomOrder);
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
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println("    //-------------------------------Sprint2-testNoteAerTooShort---------------------------------------");
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
         RoomOrder roomOrder = roomOrderRepository.findByRoomOrderId(1L);
 
         r.setRoomOrder(roomOrder);
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
             assertEquals(violations.size(), 1);
             System.out.println();
             System.out.println();
             System.out.println("//-------------------------------Sprint2-testNotePatternIsWrong---------------------------------------");
             System.out.println(e.getMessage());
             System.out.println();
         }
     }
      //-------------------------------Sprint2-testRoomOrderCanNotBeNull---------------------------------------
      @Test
      public void testRoomOrderCanNotBeNull() {
          RoomCancelOrder r = new RoomCancelOrder();
          
  
          Admin admin1 = adminRepository.findByAdminId(1L);
          RoomStatus roomStatus02 = roomStatusRepository.findByroomStatusId(1L);
          RoomOrder roomOrder = roomOrderRepository.findByRoomOrderId(1L);
  
          r.setRoomOrder(null);
          r.setNote("notee");
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
              assertEquals(violations.size(), 1);
              System.out.println();
              System.out.println();
              System.out.println("//-------------------------------Sprint2-testRoomOrderCanNotBeNull---------------------------------------");
              System.out.println(e.getMessage());
              System.out.println();
          }
      }
       //-------------------------------Sprint2-testAdminCanNotBeNull---------------------------------------
       @Test
       public void testAdminCanNotBeNull() {
           RoomCancelOrder r = new RoomCancelOrder();
           
   
           Admin admin1 = adminRepository.findByAdminId(1L);
           RoomStatus roomStatus02 = roomStatusRepository.findByroomStatusId(1L);
           RoomOrder roomOrder = roomOrderRepository.findByRoomOrderId(1L);
   
           r.setRoomOrder(roomOrder);
           r.setNote("notee");
           r.setAdmin(null);
           r.setRoomStatus(roomStatus02);
           r.setDate(new Date());
   
           try {
               entityManager.persist(r);
               entityManager.flush();
   
               fail("Should not pass to this line");
           } catch(javax.validation.ConstraintViolationException e) {
               Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
               assertEquals(violations.isEmpty(), false);
               assertEquals(violations.size(), 1);
               System.out.println();
               System.out.println();
               System.out.println("//-------------------------------Sprint2-testAdminCanNotBeNull---------------------------------------");
               System.out.println(e.getMessage());
               System.out.println();
           }
       }
        //-------------------------------Sprint2-testRStaustatusCanNotBeNull---------------------------------------
        @Test
        public void testRStaustatusCanNotBeNull() {
            RoomCancelOrder r = new RoomCancelOrder();
            
    
            Admin admin1 = adminRepository.findByAdminId(1L);
            RoomStatus roomStatus02 = roomStatusRepository.findByroomStatusId(1L);
            RoomOrder roomOrder = roomOrderRepository.findByRoomOrderId(1L);
    
            r.setRoomOrder(roomOrder);
            r.setNote("notee");
            r.setAdmin(admin1);
            r.setRoomStatus(null);
            r.setDate(new Date());
    
            try {
                entityManager.persist(r);
                entityManager.flush();
    
                fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
                System.out.println();
                System.out.println();
                System.out.println("//-------------------------------Sprint2-testRStaustatusCanNotBeNull---------------------------------------");
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
 //----------------------------------------sprint2-testRoomCancelIDMustBeUnique--------------------------------------------------
 @Test(expected=javax.persistence.PersistenceException.class)
 public void testRoomCancelIDMustBeUnique() {
    RoomCancelOrder r = new RoomCancelOrder();
		

    Admin admin1 = adminRepository.findByAdminId(1L);
    RoomStatus roomStatus02 = roomStatusRepository.findByroomStatusId(1L);


    r.setRoomCancelOrderId(1L);
    r.setNote("notee");
    r.setAdmin(admin1);
    r.setRoomStatus(roomStatus02);
    r.setDate(new Date());


     entityManager.persist(r);
     entityManager.flush();

     RoomCancelOrder r1 = new RoomCancelOrder();
		

		Admin admin = adminRepository.findByAdminId(1L);
		RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);

        r1.setRoomCancelOrderId(1L);
		r1.setNote("notee");
		r1.setAdmin(admin);
		r1.setRoomStatus(roomStatus);
		r1.setDate(new Date());



     try {
         entityManager.persist(r1);
         entityManager.flush();

         fail("ID is not unique");
     } catch(javax.validation.ConstraintViolationException e) {
         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
         assertEquals(violations.isEmpty(), false);
         assertEquals(violations.size(), 1);
         System.out.println();
         System.out.println();
         System.out.println(" //---------------------------------------sprint2-testRoomCancelIDMustBeUnique--------------------------------------------------    ");
         System.out.println();
         System.out.println();
         System.out.println(e.getMessage());
         System.out.println();
     }

 }

 //----------------------------------------sprint2-testNoteMustBeUnique--------------------------------------------------
 @Test(expected=javax.persistence.PersistenceException.class)
 public void testNoteMustBeUnique() {
    RoomCancelOrder r = new RoomCancelOrder();
		

    Admin admin1 = adminRepository.findByAdminId(1L);
    RoomStatus roomStatus02 = roomStatusRepository.findByroomStatusId(1L);


    r.setRoomCancelOrderId(1L);
    r.setNote("notee");
    r.setAdmin(admin1);
    r.setRoomStatus(roomStatus02);
    r.setDate(new Date());


     entityManager.persist(r);
     entityManager.flush();

     RoomCancelOrder r1 = new RoomCancelOrder();
		

		Admin admin = adminRepository.findByAdminId(1L);
		RoomStatus roomStatus = roomStatusRepository.findByroomStatusId(1L);

        r1.setRoomCancelOrderId(1L);
		r1.setNote("notee");
		r1.setAdmin(admin);
		r1.setRoomStatus(roomStatus);
		r1.setDate(new Date());



     try {
         entityManager.persist(r1);
         entityManager.flush();

         fail("Note is not unique");
     } catch(javax.validation.ConstraintViolationException e) {
         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
         assertEquals(violations.isEmpty(), false);
         assertEquals(violations.size(), 1);
         System.out.println();
         System.out.println();
         System.out.println(" //---------------------------------------sprint2-testNoteMustBeUnique--------------------------------------------------    ");
         System.out.println();
         System.out.println();
         System.out.println(e.getMessage());
         System.out.println();
     }

 }
    

 }

