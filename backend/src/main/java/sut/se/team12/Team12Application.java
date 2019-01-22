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
			TitleRepository titleRepository
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

			adminRepository.findAll().forEach(System.out::println);
			degreeRepository.findAll().forEach(System.out::println);
			employeeRepository.findAll().forEach(System.out::println);
			positionRepository.findAll().forEach(System.out::println);
			titleRepository.findAll().forEach(System.out::println);

		};
	}



}

