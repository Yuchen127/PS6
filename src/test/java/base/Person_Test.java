package base;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void test() {
		
		LocalDate birthday = LocalDate.of(1996, Month.JANUARY, 1);
		PersonDomainModel per = new PersonDomainModel("A", "B", "11 Street", 11111, "Newcas" , birthday);
		System.out.println(per);
		PersonDAL.addPerson(per);

	}

}
