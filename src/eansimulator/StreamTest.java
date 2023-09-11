package eansimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StreamTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCharacters() throws IOException {
		List<String> characters = Stream.characters("characters.txt");
		Employee[] employee = new Employee[characters.size()];
		String aName = "michael:MadMan Mike";
		String[] splitName = aName.split(":");
		employee[0] = new Employee(splitName[1]);
		System.out.println(employee[0].getName());
	}

}
