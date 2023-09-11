package eansimulator;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Ticket ticket1 = new Ticket(true, false, true, false, 100, 0, 15, -10, 50);
		ticket1.prompt();
		while (!ticket1.isSolved() && ticket1.getActionNum() < 5 && !ticket1.getFailed()) {
			if (ticket1.getActionNum() > 0) {
				System.out.println("Done. Still not werkin'. What do I do next?");
			}
			ticket1.promptResponse();
		}
		if (!ticket1.isSolved()) {
			System.out.println("The customer is furious and has hung up.");
		} else {
			System.out.println("My internet is working again! Woohoo!");
		}
	}

}
