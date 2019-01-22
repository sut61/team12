package sut.se.team12;

import java.text.SimpleDateFormat;
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
			MemberRepository memberRepository
						   ){
		return args -> {
			// ----------------------admin--------------------
			Admin admin1 = new Admin();
			admin1.setName("Pimpan");
			admin1.setUsername("pimpan");
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

			// ----------------------title--------------------

			Title title1 = new Title();
			title1.setTitleType("นาย");
			titleRepository.save(title1);

			Title title2 = new Title();
			title2.setTitleType("นาง");
			titleRepository.save(title2);

			Title title3 = new Title();
			title3.setTitleType("นางสาว");
			titleRepository.save(title3);

			// ----------------------degree--------------------

			Degree degree1 = new Degree();
			degree1.setDegreeType("ป.6");
			degreeRepository.save(degree1);

			Degree degree2 = new Degree();
			degree2.setDegreeType("ม.3");
			degreeRepository.save(degree2);

			Degree degree3 = new Degree();
			degree3.setDegreeType("ม.6");
			degreeRepository.save(degree3);

			Degree degree4 = new Degree();
			degree4.setDegreeType("ปวช.");
			degreeRepository.save(degree4);

			Degree degree5 = new Degree();
			degree5.setDegreeType("ปวส.");
			degreeRepository.save(degree5);

			Degree degree6 = new Degree();
			degree6.setDegreeType("ป.ตรี");
			degreeRepository.save(degree6);

			// ----------------------position--------------------

			Position position1 = new Position();
			position1.setPositionType("พนักงานทำความสะอาด");
			positionRepository.save(position1);

			Position position2 = new Position();
			position2.setPositionType("พนักงานรักษาความปลอดภัย");
			positionRepository.save(position2);

			Position position3 = new Position();
			position3.setPositionType("เทรนเนอร์");
			positionRepository.save(position3);

			// ----------------------employee--------------------
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = dateformat.parse("01/10/1996");
			Employee employee1 = new Employee();
			employee1.setAdmin(admin1);
			employee1.setId("1103900000996");
			employee1.setTitle(title3);
			employee1.setFirstName("สมศรี");
			employee1.setLastName("ใจดี");
			employee1.setBirthDate(date1);
			employee1.setPhone("0801234567");
			employee1.setEmail("somsri@gmail.com");
			employee1.setAddress("sut");
			employee1.setDegree(degree3);
			employee1.setPosition(position1);
			employeeRepository.save(employee1);

			Date date2 = dateformat.parse("25/12/1996");
			Employee employee2 = new Employee();
			employee2.setAdmin(admin5);
			employee2.setId("1103900000996");
			employee2.setTitle(title1);
			employee2.setFirstName("สมชาติ");
			employee2.setLastName("ชาติชาตรี");
			employee2.setBirthDate(date2);
			employee2.setPhone("0898765432");
			employee2.setEmail("somchai@gmail.com");
			employee2.setAddress("sut");
			employee2.setDegree(degree3);
			employee2.setPosition(position2);
			employeeRepository.save(employee2);

			Privilege privilege1 = new Privilege();
			privilege1.setPrivilegeName("Normal");
			privilege1.setPrice(799.00);
			privilegeRepository.save(privilege1);

			Privilege privilege2 = new Privilege();
			privilege2.setPrivilegeName("VIP");
			privilege2.setPrice(1599.00);
			privilegeRepository.save(privilege2);

			Province province1 = new Province();
			province1.setProvinceName("กรุงเทพมหานคร");
			provinceRepository.save(province1);

			Province province2 = new Province();
			province2.setProvinceName("กระบี่");
			provinceRepository.save(province2);

			Province province3 = new Province();
			province3.setProvinceName("กาญจนบุรี");
			provinceRepository.save(province3);

			Province province4 = new Province();
			province4.setProvinceName("กาฬสินธุ์");
			provinceRepository.save(province4);

			Province province5 = new Province();
			province5.setProvinceName("กำแพงเพชร");
			provinceRepository.save(province5);

			Province province6 = new Province();
			province6.setProvinceName("ขอนแก่น");
			provinceRepository.save(province6);

			Province province7 = new Province();
			province7.setProvinceName("จันทบุรี");
			provinceRepository.save(province7);

			Province province8 = new Province();
			province8.setProvinceName("ฉะเชิงเทรา");
			provinceRepository.save(province8);

			Province province9 = new Province();
			province9.setProvinceName("ชลบุรี");
			provinceRepository.save(province9);

			Province province10 = new Province();
			province10.setProvinceName("ชัยนาท");
			provinceRepository.save(province10);

			Province province11 = new Province();
			province11.setProvinceName("ชัยภูมิ");
			provinceRepository.save(province11);

			Province province12 = new Province();
			province12.setProvinceName("ชุมพร");
			provinceRepository.save(province12);

			Province province13 = new Province();
			province13.setProvinceName("เชียงราย");
			provinceRepository.save(province13);

			Province province14 = new Province();
			province14.setProvinceName("เชียงใหม่");
			provinceRepository.save(province14);

			Province province15 = new Province();
			province15.setProvinceName("ตรัง");
			provinceRepository.save(province15);

			Province province16 = new Province();
			province16.setProvinceName("ตราด");
			provinceRepository.save(province16);

			Province province17 = new Province();
			province17.setProvinceName("ตาก");
			provinceRepository.save(province17);

			Province province18 = new Province();
			province18.setProvinceName("นครนายก");
			provinceRepository.save(province18);

			Province province19 = new Province();
			province19.setProvinceName("นครปฐม");
			provinceRepository.save(province19);

			Province province20 = new Province();
			province20.setProvinceName("นครพนม");
			provinceRepository.save(province20);

			Province province21 = new Province();
			province21.setProvinceName("นครราชสีมา");
			provinceRepository.save(province21);

			Province province22 = new Province();
			province22.setProvinceName("นครศรีธรรมราช");
			provinceRepository.save(province22);

			Province province23 = new Province();
			province23.setProvinceName("นครสวรรค์");
			provinceRepository.save(province23);

			Province province24 = new Province();
			province24.setProvinceName("นนทบุรี");
			provinceRepository.save(province24);

			Province province25 = new Province();
			province25.setProvinceName("นราธิวาส");
			provinceRepository.save(province25);

			Province province26 = new Province();
			province26.setProvinceName("น่าน");
			provinceRepository.save(province26);

			Province province27 = new Province();
			province27.setProvinceName("บึงกาฬ");
			provinceRepository.save(province27);

			Province province28 = new Province();
			province28.setProvinceName("บุรีรัมย์");
			provinceRepository.save(province28);

			Province province29 = new Province();
			province29.setProvinceName("ปทุมธานี");
			provinceRepository.save(province29);

			Province province30 = new Province();
			province30.setProvinceName("ประจวบคีรีขันธ์");
			provinceRepository.save(province30);

			Province province31 = new Province();
			province31.setProvinceName("ปราจีนบุรี");
			provinceRepository.save(province31);

			Province province32 = new Province();
			province32.setProvinceName("ปัตตานี");
			provinceRepository.save(province32);

			Province province33 = new Province();
			province33.setProvinceName("พระนครศรีอยุธยา");
			provinceRepository.save(province33);

			Province province34 = new Province();
			province34.setProvinceName("พังงา");
			provinceRepository.save(province34);

			Province province35 = new Province();
			province35.setProvinceName("พัทลุง");
			provinceRepository.save(province35);

			Province province36 = new Province();
			province36.setProvinceName("พิจิตร");
			provinceRepository.save(province36);

			Province province37 = new Province();
			province37.setProvinceName("พิษณุโลก");
			provinceRepository.save(province37);

			Province province38 = new Province();
			province38.setProvinceName("เพชรบุรี");
			provinceRepository.save(province38);

			Province province39 = new Province();
			province39.setProvinceName("เพชรบูรณ์");
			provinceRepository.save(province39);

			Province province40 = new Province();
			province40.setProvinceName("แพร่");
			provinceRepository.save(province40);

			Province province41 = new Province();
			province41.setProvinceName("พะเยา");
			provinceRepository.save(province41);

			Province province42 = new Province();
			province42.setProvinceName("ภูเก็ต");
			provinceRepository.save(province42);

			Province province43 = new Province();
			province43.setProvinceName("มหาสารคาม");
			provinceRepository.save(province43);

			Province province44 = new Province();
			province44.setProvinceName("มุกดาหาร");
			provinceRepository.save(province44);

			Province province45 = new Province();
			province45.setProvinceName("แม่ฮ่องสอน");
			provinceRepository.save(province45);

			Province province46 = new Province();
			province46.setProvinceName("ยะลา");
			provinceRepository.save(province46);

			Province province47 = new Province();
			province47.setProvinceName("ยโสธร");
			provinceRepository.save(province47);

			Province province48 = new Province();
			province48.setProvinceName("ร้อยเอ็ด");
			provinceRepository.save(province48);

			Province province49 = new Province();
			province49.setProvinceName("ระนอง");
			provinceRepository.save(province49);

			Province province50 = new Province();
			province50.setProvinceName("ระยอง");
			provinceRepository.save(province50);

			Province province51 = new Province();
			province51.setProvinceName("ราชบุรี");
			provinceRepository.save(province15);

			Province province52 = new Province();
			province52.setProvinceName("ลพบุรี");
			provinceRepository.save(province52);

			Province province53 = new Province();
			province53.setProvinceName("ลำปาง");
			provinceRepository.save(province53);

			Province province54 = new Province();
			province54.setProvinceName("ลำพูน");
			provinceRepository.save(province54);

			Province province55 = new Province();
			province55.setProvinceName("เลย");
			provinceRepository.save(province55);

			Province province56 = new Province();
			province56.setProvinceName("ศรีสะเกษ");
			provinceRepository.save(province56);

			Province province57 = new Province();
			province57.setProvinceName("สกลนคร");
			provinceRepository.save(province57);

			Province province58 = new Province();
			province58.setProvinceName("สงขลา");
			provinceRepository.save(province58);

			Province province59 = new Province();
			province59.setProvinceName("สตูล");
			provinceRepository.save(province59);

			Province province60 = new Province();
			province60.setProvinceName("สมุทรปราการ");
			provinceRepository.save(province60);

			Province province61 = new Province();
			province61.setProvinceName("สมุทรสงคราม");
			provinceRepository.save(province61);

			Province province62 = new Province();
			province62.setProvinceName("สมุทรสาคร");
			provinceRepository.save(province62);

			Province province63 = new Province();
			province63.setProvinceName("สระแก้ว");
			provinceRepository.save(province63);

			Province province64 = new Province();
			province64.setProvinceName("สระบุรี");
			provinceRepository.save(province64);

			Province province65 = new Province();
			province65.setProvinceName("สิงห์บุรี");
			provinceRepository.save(province65);

			Province province66 = new Province();
			province66.setProvinceName("สุโขทัย");
			provinceRepository.save(province66);

			Province province67 = new Province();
			province67.setProvinceName("สุพรรณบุรี");
			provinceRepository.save(province67);

			Province province68 = new Province();
			province68.setProvinceName("สุราษฎร์ธานี");
			provinceRepository.save(province68);

			Province province69 = new Province();
			province69.setProvinceName("สุรินทร์");
			provinceRepository.save(province69);

			Province province70 = new Province();
			province70.setProvinceName("หนองคาย");
			provinceRepository.save(province70);

			Province province71 = new Province();
			province71.setProvinceName("หนองบัวลำภู");
			provinceRepository.save(province71);

			Province province72 = new Province();
			province72.setProvinceName("อ่างทอง");
			provinceRepository.save(province72);

			Province province73 = new Province();
			province73.setProvinceName("อุดรธานี");
			provinceRepository.save(province73);

			Province province74 = new Province();
			province74.setProvinceName("อุทัยธานี");
			provinceRepository.save(province4);

			Province province75 = new Province();
			province75.setProvinceName("อุตรดิตถ์");
			provinceRepository.save(province75);

			Province province76 = new Province();
			province76.setProvinceName("อุบลราชธานี");
			provinceRepository.save(province76);

			Province province77 = new Province();
			province77.setProvinceName("อำนาจเจริญ");
			provinceRepository.save(province77);


			Member member1 = new Member();
			member1.setName("neuy");
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


			adminRepository.findAll().forEach(System.out::println);
			degreeRepository.findAll().forEach(System.out::println);
			employeeRepository.findAll().forEach(System.out::println);
			positionRepository.findAll().forEach(System.out::println);
			titleRepository.findAll().forEach(System.out::println);
			provinceRepository.findAll().forEach(System.out::println);
			privilegeRepository.findAll().forEach(System.out::println);
			memberRepository.findAll().forEach(System.out::println);

		};
	}



}

