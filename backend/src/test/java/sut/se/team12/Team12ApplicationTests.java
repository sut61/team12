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
public class Team12ApplicationTests {
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

	@Test
	public void contextLoads() {
	}
}	 
