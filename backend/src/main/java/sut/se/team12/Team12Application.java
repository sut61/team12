package sut.se.team12;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sut.se.team12.entity.*;
import sut.se.team12.repository.*;

@SpringBootApplication
public class Team12Application {

	public static void main(String[] args) {
		SpringApplication.run(Team12Application.class, args);
	}

	@Bean
	ApplicationRunner init(
			AdminRepository adminRepository,
			DegreeRepository degreeRepository,
			EmployeeRepository employeeRepository,
			PositionRepository positionRepository,
			TitleRepository titleRepository,
			ProvinceRepository provinceRepository,
			PrivilegeRepository privilegeRepository,
			MemberRepository memberRepository,
			LeaseRepository leaseRepository,
			LeaseAccessoryRepository leaseAccessoryRepository,
			LeaseDurationRepository leaseDurationRepository,
			FieldDurationRepository fieldDurationRepository,
			FieldRepository fieldRepository,
			FieldOrderRepository fieldOrderRepository,
			RoomRepository roomRepository,
			RoomDurationRepository roomDurationRepository,
			RoomCancelOrderRepository roomCancelOrderRepository,
			RoomStatusRepository roomStatusRepository,
			RoomOrderRepository roomOrderRepository,
			TrainingRepository trainingRepository,
			TrainingTypeRepository trainingTypeRepository,
			TrainingProgramRepository trainingProgramRepository,
			TicketRepository ticketRepository,
			TicketTypeRepository ticketTypeRepository,
			LockerRepository lockerRepository,
			LockerDurationRepository lockerDurationRepository,
			LockerOrderRepository lockerOrderRepository,
			NotificationRepository notificationRepository
						   ){
		return args -> {

			// ---------------------- Admin --------------------

			Admin admin1 = new Admin();
			admin1.setName("Pimpun");
			admin1.setUsername("pimpun");
			admin1.setPassword("1234");
			adminRepository.save(admin1);

			Admin admin2 = new Admin();
			admin2.setName("Rachataporn");
			admin2.setUsername("rachataporn");
			admin2.setPassword("1234");
			adminRepository.save(admin2);

			Admin admin3 = new Admin();
			admin3.setName("Supanniga");
			admin3.setUsername("supanniga");
			admin3.setPassword("1234");
			adminRepository.save(admin3);

			Admin admin4 = new Admin();
			admin4.setName("Chalermchai");
			admin4.setUsername("chalermchai");
			admin4.setPassword("1234");
			adminRepository.save(admin4);

			Admin admin5 = new Admin();
			admin5.setName("Panjawan");
			admin5.setUsername("panjawan");
			admin5.setPassword("1234");
			adminRepository.save(admin5);

			Admin admin6 = new Admin();
			admin6.setName("Sasiprapha");
			admin6.setUsername("sasiprapha");
			admin6.setPassword("1234");
			adminRepository.save(admin6);

			// ---------------------- Title --------------------

			Title title1 = new Title();
			title1.setTitleType("Mr.");
			titleRepository.save(title1);

			Title title2 = new Title();
			title2.setTitleType("Mrs.");
			titleRepository.save(title2);

			Title title3 = new Title();
			title3.setTitleType("Miss.");
			titleRepository.save(title3);

			// ---------------------- Degree --------------------

			Degree degree1 = new Degree();
			degree1.setDegreeType("Elementary School");
			degreeRepository.save(degree1);

			Degree degree2 = new Degree();
			degree2.setDegreeType("Middle School");
			degreeRepository.save(degree2);

			Degree degree3 = new Degree();
			degree3.setDegreeType("High School");
			degreeRepository.save(degree3);

			Degree degree4 = new Degree();
			degree4.setDegreeType("Vocational Certificate");
			degreeRepository.save(degree4);

			Degree degree5 = new Degree();
			degree5.setDegreeType("Diploma");
			degreeRepository.save(degree5);

			Degree degree6 = new Degree();
			degree6.setDegreeType("Bachelor");
			degreeRepository.save(degree6);

			// ---------------------- Position --------------------

			Position position1 = new Position();
			position1.setPositionType("Clean staff");
			positionRepository.save(position1);

			Position position2 = new Position();
			position2.setPositionType("Security guard");
			positionRepository.save(position2);

			Position position3 = new Position();
			position3.setPositionType("Trainer");
			positionRepository.save(position3);

			Position position4 = new Position();
			position4.setPositionType("Accountant");
			positionRepository.save(position4);

			// ---------------------- Employee --------------------

			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = dateformat.parse("1996-10-01");
			Employee employee1 = new Employee();
			employee1.setAdmin(admin1);
			employee1.setId("1111111111111");
			employee1.setTitle(title3);
			employee1.setFirstName("Somsri");
			employee1.setLastName("Jaidee");
			employee1.setBirthDate(date1);
			employee1.setPhone("0801234567");
			employee1.setEmail("somsri@gmail.com");
			employee1.setAddress("SUT");
			employee1.setDegree(degree3);
			employee1.setPosition(position1);
			employeeRepository.save(employee1);

			Date date2 = dateformat.parse("1996-12-02");
			Employee employee2 = new Employee();
			employee2.setAdmin(admin5);
			employee2.setId("2222222222222");
			employee2.setTitle(title1);
			employee2.setFirstName("Somchai");
			employee2.setLastName("Jaikla");
			employee2.setBirthDate(date2);
			employee2.setPhone("0898765432");
			employee2.setEmail("somchai@gmail.com");
			employee2.setAddress("SUT");
			employee2.setDegree(degree3);
			employee2.setPosition(position2);
			employeeRepository.save(employee2);

			Date date3 = dateformat.parse("1996-07-01");
			Employee employee3 = new Employee();
			employee3.setAdmin(admin5);
			employee3.setId("3333333333333");
			employee3.setTitle(title1);
			employee3.setFirstName("Sompong");
			employee3.setLastName("Jaiyen");
			employee3.setBirthDate(date3);
			employee3.setPhone("0898765432");
			employee3.setEmail("somchai@gmail.com");
			employee3.setAddress("SUT");
			employee3.setDegree(degree6);
			employee3.setPosition(position3);
			employeeRepository.save(employee3);
			
			//--------------------- Field ----------------------------

			Field Field1 = new Field();
			Field1.setFieldName("สนามฟุตบอล1");
			fieldRepository.save(Field1);
			
			Field Field2 = new Field();
			Field2.setFieldName("สนามฟุตบอล2");
			fieldRepository.save(Field2);
			
			Field Field3 = new Field();
			Field3.setFieldName("สนามฟุตบอล3");
			fieldRepository.save(Field3);
			
			Field Field4 = new Field();
			Field4.setFieldName("สนามฟุตบอล4");
			fieldRepository.save(Field4);
			
			Field Field5 = new Field();
			Field5.setFieldName("สนามฟุตบอล5");
			fieldRepository.save(Field5);
			
			//--------------------- FieldDuration -----------------
			
			FieldDuration FieldDuration1 = new FieldDuration();
			FieldDuration1.setFieldDuration("08:00-10:00 น.");
			fieldDurationRepository.save(FieldDuration1);
			
			FieldDuration FieldDuration2 = new FieldDuration();
			FieldDuration2.setFieldDuration("10:00-12:00 น.");
			fieldDurationRepository.save(FieldDuration2);
			
			FieldDuration FieldDuration3 = new FieldDuration();
			FieldDuration3.setFieldDuration("13:00-15:00 น.");
			fieldDurationRepository.save(FieldDuration3);
			
			FieldDuration FieldDuration4 = new FieldDuration();
			FieldDuration4.setFieldDuration("15:00-17:00 น.");
			fieldDurationRepository.save(FieldDuration4);
			
			FieldDuration FieldDuration5 = new FieldDuration();
			FieldDuration5.setFieldDuration("17:00-19:00 น.");
			fieldDurationRepository.save(FieldDuration5);
			
			FieldDuration FieldDuration6 = new FieldDuration();
			FieldDuration6.setFieldDuration("19:00-21:00 น.");
			fieldDurationRepository.save(FieldDuration6);


//----------------------------Locker---------------------------------

			
			Locker Locker1 = new Locker();
			Locker1.setLockerName("LOCKER 001");
			lockerRepository.save(Locker1);

			Locker Locker2 = new Locker();
			Locker2.setLockerName("LOCKER 002");
			lockerRepository.save(Locker2);

			Locker Locker3 = new Locker();
			Locker3.setLockerName("LOCKER 003");
			lockerRepository.save(Locker3);

			Locker Locker4 = new Locker();
			Locker4.setLockerName("LOCKER 004");
			lockerRepository.save(Locker4);

			Locker Locker5 = new Locker();
			Locker5.setLockerName("LOCKER 005");
			lockerRepository.save(Locker5);

			Locker Locker6 = new Locker();
			Locker6.setLockerName("LOCKER 006");
			lockerRepository.save(Locker6);

			Locker Locker7 = new Locker();
			Locker7.setLockerName("LOCKER 007");
			lockerRepository.save(Locker7);

			Locker Locker8 = new Locker();
			Locker8.setLockerName("LOCKER 008");
			lockerRepository.save(Locker8);

			Locker Locker9 = new Locker();
			Locker9.setLockerName("LOCKER 009");
			lockerRepository.save(Locker9);


			Locker Locker10 = new Locker();
			Locker10.setLockerName("LOCKER 010");
			lockerRepository.save(Locker10);

			Locker Locker11 = new Locker();
			Locker11.setLockerName("LOCKER 011");
			lockerRepository.save(Locker11);


			Locker Locker12 = new Locker();
			Locker12.setLockerName("LOCKER 012");
			lockerRepository.save(Locker12);
			

//-------------------LockerDuration--------------------------

			LockerDuration LockerDuration1 = new LockerDuration();
			LockerDuration1.setLockerDuration("08:00-10:00 น.");
			lockerDurationRepository.save(LockerDuration1);

			LockerDuration LockerDuration2 = new LockerDuration();
			LockerDuration2.setLockerDuration("10:00-12:00 น.");
			lockerDurationRepository.save(LockerDuration2);


			LockerDuration LockerDuration3 = new LockerDuration();
			LockerDuration3.setLockerDuration("13:00-15:00 น.");
			lockerDurationRepository.save(LockerDuration3);


			LockerDuration LockerDuration4 = new LockerDuration();
			LockerDuration4.setLockerDuration("15:00-17:00 น.");
			lockerDurationRepository.save(LockerDuration4);


			LockerDuration LockerDuration5 = new LockerDuration();
			LockerDuration5.setLockerDuration("17:00-19:00 น.");
			lockerDurationRepository.save(LockerDuration5);


			LockerDuration LockerDuration6 = new LockerDuration();
			LockerDuration6.setLockerDuration("19:00-21:00 น.");
			lockerDurationRepository.save(LockerDuration6);




//------------------------------ Privilege ----------------------------------

			Privilege privilege1 = new Privilege();
			privilege1.setPrivilegeName("Normal");
			privilege1.setPrice(799.00);
			privilegeRepository.save(privilege1);

			Privilege privilege2 = new Privilege();
			privilege2.setPrivilegeName("VIP");
			privilege2.setPrice(1599.00);
			privilegeRepository.save(privilege2);

			//------------------------Member-----------------------------

			Province province1 = new Province();
			province1.setProvinceName("Amnat Charoen");
			provinceRepository.save(province1);

			Province province2 = new Province();
			province2.setProvinceName("Ang Thong");
			provinceRepository.save(province2);

			Province province3 = new Province();
			province3.setProvinceName("Bangkok");
			provinceRepository.save(province3);

			Province province4 = new Province();
			province4.setProvinceName("Bueng Kan");
			provinceRepository.save(province4);

			Province province5 = new Province();
			province5.setProvinceName("Buriram");
			provinceRepository.save(province5);

			Province province6 = new Province();
			province6.setProvinceName("Chachoengsao");
			provinceRepository.save(province6);

			Province province7 = new Province();
			province7.setProvinceName("Chainat");
			provinceRepository.save(province7);

			Province province8 = new Province();
			province8.setProvinceName("Chaiyaphum");
			provinceRepository.save(province8);

			Province province9 = new Province();
			province9.setProvinceName("Chanthaburi");
			provinceRepository.save(province9);

			Province province10 = new Province();
			province10.setProvinceName("Chiang Mai");
			provinceRepository.save(province10);

			Province province11 = new Province();
			province11.setProvinceName("Chiang Rai");
			provinceRepository.save(province11);

			Province province12 = new Province();
			province12.setProvinceName("Chonburi");
			provinceRepository.save(province12);

			Province province13 = new Province();
			province13.setProvinceName("Chumphon");
			provinceRepository.save(province13);

			Province province14 = new Province();
			province14.setProvinceName("Kalasin");
			provinceRepository.save(province14);

			Province province15 = new Province();
			province15.setProvinceName("Kamphaeng Phet");
			provinceRepository.save(province15);

			Province province16 = new Province();
			province16.setProvinceName("Kanchanaburi");
			provinceRepository.save(province16);

			Province province17 = new Province();
			province17.setProvinceName("Khon Kaen");
			provinceRepository.save(province17);

			Province province18 = new Province();
			province18.setProvinceName("Krabi");
			provinceRepository.save(province18);

			Province province19 = new Province();
			province19.setProvinceName("Lampang");
			provinceRepository.save(province19);

			Province province20 = new Province();
			province20.setProvinceName("Lamphun");
			provinceRepository.save(province20);

			Province province21 = new Province();
			province21.setProvinceName("Loei");
			provinceRepository.save(province21);

			Province province22 = new Province();
			province22.setProvinceName("Lopburi");
			provinceRepository.save(province22);

			Province province23 = new Province();
			province23.setProvinceName("Mae Hong Son");
			provinceRepository.save(province23);

			Province province24 = new Province();
			province24.setProvinceName("Maha Sarakham");
			provinceRepository.save(province24);

			Province province25 = new Province();
			province25.setProvinceName("Mukdahan");
			provinceRepository.save(province25);

			Province province26 = new Province();
			province26.setProvinceName("Nakhon Nayok");
			provinceRepository.save(province26);

			Province province27 = new Province();
			province27.setProvinceName("Nakhon Pathom");
			provinceRepository.save(province27);

			Province province28 = new Province();
			province28.setProvinceName("Nakhon Phanom");
			provinceRepository.save(province28);

			Province province29 = new Province();
			province29.setProvinceName("Nakhon Ratchasima");
			provinceRepository.save(province29);

			Province province30 = new Province();
			province30.setProvinceName("Nakhon Sawan");
			provinceRepository.save(province30);

			Province province31 = new Province();
			province31.setProvinceName("Nakhon Si Thammarat");
			provinceRepository.save(province31);

			Province province32 = new Province();
			province32.setProvinceName("Nan");
			provinceRepository.save(province32);

			Province province33 = new Province();
			province33.setProvinceName("Narathiwat");
			provinceRepository.save(province33);

			Province province34 = new Province();
			province34.setProvinceName("Nong Bua Lamphu");
			provinceRepository.save(province34);

			Province province35 = new Province();
			province35.setProvinceName("Nong Khai");
			provinceRepository.save(province35);

			Province province36 = new Province();
			province36.setProvinceName("Nonthaburi");
			provinceRepository.save(province36);

			Province province37 = new Province();
			province37.setProvinceName("Pathum Thani");
			provinceRepository.save(province37);

			Province province38 = new Province();
			province38.setProvinceName("Pattani");
			provinceRepository.save(province38);

			Province province39 = new Province();
			province39.setProvinceName("Phang Nga");
			provinceRepository.save(province39);

			Province province40 = new Province();
			province40.setProvinceName("Phatthalung");
			provinceRepository.save(province40);

			Province province41 = new Province();
			province41.setProvinceName("Phayao");
			provinceRepository.save(province41);

			Province province42 = new Province();
			province42.setProvinceName("Phetchabun");
			provinceRepository.save(province42);

			Province province43 = new Province();
			province43.setProvinceName("Phetchaburi");
			provinceRepository.save(province43);

			Province province44 = new Province();
			province44.setProvinceName("Phichit");
			provinceRepository.save(province44);

			Province province45 = new Province();
			province45.setProvinceName("Phitsanulok");
			provinceRepository.save(province45);

			Province province46 = new Province();
			province46.setProvinceName("Phra Nakhon Si Ayutthaya");
			provinceRepository.save(province46);

			Province province47 = new Province();
			province47.setProvinceName("Phrae");
			provinceRepository.save(province47);

			Province province48 = new Province();
			province48.setProvinceName("Phuket");
			provinceRepository.save(province48);

			Province province49 = new Province();
			province49.setProvinceName("Prachinburi");
			provinceRepository.save(province49);

			Province province50 = new Province();
			province50.setProvinceName("Prachuap Khiri Khan");
			provinceRepository.save(province50);

			Province province51 = new Province();
			province51.setProvinceName("Ranong");
			provinceRepository.save(province15);

			Province province52 = new Province();
			province52.setProvinceName("Ratchaburi");
			provinceRepository.save(province52);

			Province province53 = new Province();
			province53.setProvinceName("Rayong");
			provinceRepository.save(province53);

			Province province54 = new Province();
			province54.setProvinceName("Roi Et");
			provinceRepository.save(province54);

			Province province55 = new Province();
			province55.setProvinceName("Sa Kaeo");
			provinceRepository.save(province55);

			Province province56 = new Province();
			province56.setProvinceName("Sakon Nakhon");
			provinceRepository.save(province56);

			Province province57 = new Province();
			province57.setProvinceName("Samut Prakan");
			provinceRepository.save(province57);

			Province province58 = new Province();
			province58.setProvinceName("Samut Sakhon");
			provinceRepository.save(province58);

			Province province59 = new Province();
			province59.setProvinceName("Samut Songkhram");
			provinceRepository.save(province59);

			Province province60 = new Province();
			province60.setProvinceName("Saraburi");
			provinceRepository.save(province60);

			Province province61 = new Province();
			province61.setProvinceName("Satun");
			provinceRepository.save(province61);

			Province province62 = new Province();
			province62.setProvinceName("Sing Buri");
			provinceRepository.save(province62);

			Province province63 = new Province();
			province63.setProvinceName("Sisaket");
			provinceRepository.save(province63);

			Province province64 = new Province();
			province64.setProvinceName("Songkhla");
			provinceRepository.save(province64);

			Province province65 = new Province();
			province65.setProvinceName("Sukhothai");
			provinceRepository.save(province65);

			Province province66 = new Province();
			province66.setProvinceName("Suphan Buri");
			provinceRepository.save(province66);

			Province province67 = new Province();
			province67.setProvinceName("Surat Thani");
			provinceRepository.save(province67);

			Province province68 = new Province();
			province68.setProvinceName("Surin");
			provinceRepository.save(province68);

			Province province69 = new Province();
			province69.setProvinceName("Tak");
			provinceRepository.save(province69);

			Province province70 = new Province();
			province70.setProvinceName("Trang");
			provinceRepository.save(province70);

			Province province71 = new Province();
			province71.setProvinceName("Trat");
			provinceRepository.save(province71);

			Province province72 = new Province();
			province72.setProvinceName("Ubon Ratchathani");
			provinceRepository.save(province72);

			Province province73 = new Province();
			province73.setProvinceName("Udon Thani");
			provinceRepository.save(province73);

			Province province74 = new Province();
			province74.setProvinceName("Uthai Thani");
			provinceRepository.save(province4);

			Province province75 = new Province();
			province75.setProvinceName("Uttaradit");
			provinceRepository.save(province75);

			Province province76 = new Province();
			province76.setProvinceName("Yala");
			provinceRepository.save(province76);

			Province province77 = new Province();
			province77.setProvinceName("Yasothon");
			provinceRepository.save(province77);

//------------------------Member-----------------------------

			Member member1 = new Member();
			member1.setFirstName("Panjawan");
			member1.setLastName("Suphintritipes");
			member1.setAge(21);
			member1.setBirthday(new Date());
			member1.setEmail("Nnneuy@gmail.com");
			member1.setPhoneNumber("0971982024");
			member1.setAddress("174,176");
			member1.setSubDistrict("Buayai");
			member1.setDistrict("Buayai");
			member1.setTitle(title3);
			member1.setPrivilege(privilege1);
			member1.setProvince(province21);
			member1.setAdmin(admin1);
			memberRepository.save(member1);

			// ------------------------- LeaseAccessory ------------------------------------------

			LeaseAccessory accessory1 = new LeaseAccessory();
			accessory1.setAccessoryName("Football");
			leaseAccessoryRepository.save(accessory1);

			LeaseAccessory accessory2 = new LeaseAccessory();
			accessory2.setAccessoryName("Basketball");
			leaseAccessoryRepository.save(accessory2);

			LeaseAccessory accessory3 = new LeaseAccessory();
			accessory3.setAccessoryName("Volleyball");
			leaseAccessoryRepository.save(accessory3);

			LeaseAccessory accessory4 = new LeaseAccessory();
			accessory4.setAccessoryName("Pingpongball");
			leaseAccessoryRepository.save(accessory4);

			LeaseAccessory accessory5 = new LeaseAccessory();
			accessory5.setAccessoryName("Tennisball");
			leaseAccessoryRepository.save(accessory5);

			LeaseAccessory accessory6 = new LeaseAccessory();
			accessory6.setAccessoryName("Shuttlecock");
			leaseAccessoryRepository.save(accessory6);

			LeaseAccessory accessory7 = new LeaseAccessory();
			accessory7.setAccessoryName("Badminton racket");
			leaseAccessoryRepository.save(accessory7);

			LeaseAccessory accessory8 = new LeaseAccessory();
			accessory8.setAccessoryName("Tennis racket");
			leaseAccessoryRepository.save(accessory8);

			LeaseAccessory accessory9 = new LeaseAccessory();
			accessory9.setAccessoryName("Pingpong racket");
			leaseAccessoryRepository.save(accessory9);

			LeaseAccessory accessory10 = new LeaseAccessory();
			accessory10.setAccessoryName("Automatic table tennis ball");
			leaseAccessoryRepository.save(accessory10);

			LeaseAccessory accessory11 = new LeaseAccessory();
			accessory11.setAccessoryName("Automatic tennis ball");
			leaseAccessoryRepository.save(accessory11);

			// ---------------------------- LeaseDuration ----------------------------------

			LeaseDuration duration1 = new LeaseDuration();
			duration1.setDurationName("1 Hour");
			leaseDurationRepository.save(duration1);

			LeaseDuration duration2 = new LeaseDuration();
			duration2.setDurationName("2 Hour");
			leaseDurationRepository.save(duration2);

			LeaseDuration duration3 = new LeaseDuration();
			duration3.setDurationName("3 Hour");
			leaseDurationRepository.save(duration3);

			LeaseDuration duration4 = new LeaseDuration();
			duration4.setDurationName("4 Hour");
			leaseDurationRepository.save(duration4);

			LeaseDuration duration5 = new LeaseDuration();
			duration5.setDurationName("5 Hour");
			leaseDurationRepository.save(duration5);

			// -------------------- Lease ------------------------------------
			
			Lease lease1 = new Lease();
			lease1.setMember(member1);
			lease1.setAccessory(accessory1);
			lease1.setDuration(duration1);
			lease1.setNote("Borrow a soccer ball to practice");
			leaseRepository.save(lease1);

			// ----------------- FieldOrder ----------------------------------

			FieldOrder fieldOrder1 = new FieldOrder();
			fieldOrder1.setAdmin(admin6);
			fieldOrder1.setField(Field2);
			fieldOrder1.setMember(member1);
			fieldOrder1.setFieldDuration(FieldDuration2);
			fieldOrder1.setDate(date1);
			fieldOrderRepository.save(fieldOrder1);
//--------------------------LockerOrder------------------------------------

			LockerOrder lockerOrder1 = new LockerOrder();
			lockerOrder1.setAdmin(admin6);
			lockerOrder1.setLocker(Locker4);
			lockerOrder1.setMember(member1);
			lockerOrder1.setLockerDuration(LockerDuration2);
			lockerOrder1.setDate(date1);
			lockerOrderRepository.save(lockerOrder1);
			//------------------------ Room ----------------------

			Room Room01 = new Room();
			Room01.setRoomNumber("R001");
			roomRepository.save(Room01);

			Room Room02 = new Room();
			Room02.setRoomNumber("R002");
			roomRepository.save(Room02);

			Room Room03 = new Room();
			Room03.setRoomNumber("R003");
			roomRepository.save(Room03);

			Room Room04 = new Room();
			Room04.setRoomNumber("R004");
			roomRepository.save(Room04);

			Room Room05 = new Room();
			Room05.setRoomNumber("R005");
			roomRepository.save(Room05);

			//---------------------- RoomDuration -------------------

			RoomDuration roomDuration01 = new RoomDuration();
			roomDuration01.setRoomDuration("09.00 AM - 10.30 AM");
			roomDurationRepository.save(roomDuration01);

			RoomDuration roomDuration02 = new RoomDuration();
			roomDuration02.setRoomDuration("11.00 AM - 12.30 AM");
			roomDurationRepository.save(roomDuration02);

			RoomDuration roomDuration03 = new RoomDuration();
			roomDuration03.setRoomDuration("01.00 PM - 02.30 PM");
			roomDurationRepository.save(roomDuration03);

			RoomDuration roomDuration04 = new RoomDuration();
			roomDuration04.setRoomDuration("03.00 PM - 04.30 PM");
			roomDurationRepository.save(roomDuration04);
			
			//----------------------------------Status----------------------------------------------------

			RoomStatus roomStatus01 = new RoomStatus();
			roomStatus01.setRoomStatus("จองแล้ว");
			roomStatusRepository.save(roomStatus01);

			RoomStatus roomStatus02 = new RoomStatus();
			roomStatus02.setRoomStatus("ยกเลิกแล้ว");
			roomStatusRepository.save(roomStatus02);

			//---------------------------------RoomOrder-------------------------------------------------
			
			RoomOrder roomOrder01 = new RoomOrder();
			Date date5 = dateformat.parse("2019-10-01");
			roomOrder01.setAdmin(admin1);
			roomOrder01.setRoom(Room05);
			roomOrder01.setRoomDuration(roomDuration03);
			roomOrder01.setDate(date5);
			roomOrder01.setMember(member1);
			roomOrder01.setRoomStatus(roomStatus01);
			roomOrderRepository.save(roomOrder01);

			//-----------------------------------RoomCancel-----------------------------------------------

			RoomCancelOrder roomCancel = new RoomCancelOrder();

			roomCancel.setRoomOrder(roomOrder01);
			roomCancel.setNote("note");
			roomCancel.setAdmin(admin1);
			roomCancel.setRoomStatus(roomStatus02);
			roomCancel.setDate(new Date());
			roomCancelOrderRepository.save(roomCancel);



			// --------------------------------- TrainingType --------------------------------------------

			TrainingType trainingType1 = new TrainingType();
			trainingType1.setTypeName("In-House Training");
			trainingTypeRepository.save(trainingType1);

			TrainingType trainingType2 = new TrainingType();
			trainingType2.setTypeName("Public Training");
			trainingTypeRepository.save(trainingType2);

			// ---------------------------------- TrainingProgram --------------------------------------------

			TrainingProgram trainingProgram1 = new TrainingProgram();
			trainingProgram1.setProgramName("Technical Skills");
			trainingProgramRepository.save(trainingProgram1);

			TrainingProgram trainingProgram2 = new TrainingProgram();
			trainingProgram2.setProgramName("Policies and Procedures");
			trainingProgramRepository.save(trainingProgram2);

			TrainingProgram trainingProgram3 = new TrainingProgram();
			trainingProgram3.setProgramName("Personal Skills");
			trainingProgramRepository.save(trainingProgram3);

			TrainingProgram trainingProgram4 = new TrainingProgram();
			trainingProgram4.setProgramName("People Skills");
			trainingProgramRepository.save(trainingProgram4);

			// ---------------------------------- Training -------------------------------------------

			Date date4 = dateformat.parse("1996-07-01");
			Training training1 = new Training();
			training1.setAdmin(admin1);
			training1.setTitle("title");
			training1.setDescription("description");
			training1.setDateFrom(date4);
			training1.setDateTo(date4);
			training1.setTrainingType(trainingType1);
			training1.setTrainingProgram(trainingProgram1);
			training1.setInstructor("instructor");
			training1.setLocation("location");
			training1.setEnrollment(50);
			training1.setCost(4800L);
			trainingRepository.save(training1);

				//---------------------Ticket Type---------------------
				TicketType ticketType1 = new TicketType();
				ticketType1.setTicketType("Kids");
				ticketType1.setPrice(30.00);
				ticketTypeRepository.save(ticketType1);
				TicketType ticketType2 = new TicketType();
				ticketType2.setTicketType("Adult");
				ticketType2.setPrice(50.00);
				ticketTypeRepository.save(ticketType2);
	
				//--------------------Ticket--------------------------
				Ticket ticket1 = new Ticket();
				ticket1.setTicketType(ticketType2);
				ticket1.setName("Gum");
				ticket1.setPhoneNumber("0987654321");
				ticket1.setField(Field3);
				ticket1.setDate(new Date());
				ticket1.setTime(LocalTime.now());
				ticket1.setAdmin(admin5);
				ticketRepository.save(ticket1);
	
				Ticket ticket2 = new Ticket();
				ticket2.setTicketType(ticketType1);
				ticket2.setName("Bear");
				ticket2.setPhoneNumber("0984234123");
				ticket2.setField(Field5);
				ticket2.setDate(new Date());
				ticket2.setTime(LocalTime.now());
				ticket2.setAdmin(admin3);
				ticketRepository.save(ticket2);

				//--------------------------Notification----------------------------//

				Notification notification1 = new Notification();
				notification1.setAdmin(admin1);
				notification1.setEmployee(employee2);
				notification1.setField(Field1);
				notification1.setNote("Nets of damaged doors");
				notificationRepository.save(notification1);

			// --------------------------------- Print --------------------------------------------
			
			adminRepository.findAll().forEach(System.out::println);
			degreeRepository.findAll().forEach(System.out::println);
			employeeRepository.findAll().forEach(System.out::println);
			positionRepository.findAll().forEach(System.out::println);
			titleRepository.findAll().forEach(System.out::println);
			provinceRepository.findAll().forEach(System.out::println);
			privilegeRepository.findAll().forEach(System.out::println);
			memberRepository.findAll().forEach(System.out::println);
			leaseRepository.findAll().forEach(System.out::println);
			fieldRepository.findAll().forEach(System.out::println);
			ticketTypeRepository.findAll().forEach(System.out::println);
			ticketRepository.findAll().forEach(System.out::println);
			notificationRepository.findAll().forEach(System.out::println);
		};
	}
}

