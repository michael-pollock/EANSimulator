package eansimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StaffTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws IOException{
		Staff staff = new Staff();
		System.out.println("Check");
		staff.michael.addQuote("Somethin");
		System.out.println(staff.michael.getQuote());
	}

}
