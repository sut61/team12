package sut.se.team12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team12.entity.*;
import sut.se.team12.repository.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import java.text.ParseException;
// import java.text.SimpleDateFormat;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private AdminRepository adminRepository;
    @Autowired private TitleRepository titleRepository;
    @Autowired private DegreeRepository degreeRepository;
    @Autowired private PositionRepository positionRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/employee")
    public Collection<Employee> Admin() {
        return employeeRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/employee/register/{admin}/{title}/{degree}/{position}/{id}/{firstName}/{lastName}/{phone}/{email}/{address}/{birthDate}")
    public Employee employee(
        @PathVariable Long admin, 
        @PathVariable Long title,
        @PathVariable Long degree,
        @PathVariable Long position,
        @PathVariable String id,
        @PathVariable String firstName,
        @PathVariable String lastName,
        @PathVariable String phone,
        @PathVariable String email,
        @PathVariable String address,
        @PathVariable Date birthDate) throws ParseException {

            Employee newEmployee = new Employee();

            Admin _admin = adminRepository.findByAdminId(admin);
            Title _title = titleRepository.findByTitleId(title);
            Degree _degree = degreeRepository.findByDegreeId(degree);
            Position _position = positionRepository.findByPositionId(position);

            // String pattern = "dd/MM/yyyy";
            // SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            // String date = dateFormat.format(birthDate);
            // Date d = dateFormat.parse(birthDate.toString());

            newEmployee.setAdmin(_admin);
            newEmployee.setId(id);
            newEmployee.setTitle(_title);
            newEmployee.setFirstName(firstName);
            newEmployee.setLastName(lastName);
            newEmployee.setBirthDate(birthDate);
            newEmployee.setPhone(phone);
            newEmployee.setEmail(email);
            newEmployee.setAddress(address);
            newEmployee.setDegree(_degree);
            newEmployee.setPosition(_position);
        return employeeRepository.save(newEmployee);
    }

    @DeleteMapping("/employee/{id}")
	void deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
    }
    
    
}
