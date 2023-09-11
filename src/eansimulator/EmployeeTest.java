package eansimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDrinks() {
		Employee spicyMike = new Employee("SpicyMike");
		spicyMike.getName().equals("SpicyMike");
		
		while (spicyMike.getBloodAlcoholContent() < 100) {
			spicyMike.drinkTequila();
		}
		spicyMike.getToxicology();
		assertTrue(spicyMike.getBloodAlcoholContent() == 100);
		
		while (spicyMike.getBloodAlcoholContent() > 0 
				|| spicyMike.getBloodCoffeeContent() > 0) {
			spicyMike.useRestroom();
		}
		assertTrue(spicyMike.getBloodAlcoholContent() == 0);
		assertTrue(spicyMike.getBloodCoffeeContent() == 0);
		
		while (spicyMike.getHydration() < 100) {
			spicyMike.drinkWater();
		}
		assertTrue(spicyMike.getHydration() == 100);
		
		while (spicyMike.getBloodAlcoholContent() < 100) {
			spicyMike.drinkBeer();
		}
		spicyMike.getToxicology();
		assertTrue(spicyMike.getBloodAlcoholContent() == 100);
		
		while (spicyMike.getBloodAlcoholContent() > 0 
				|| spicyMike.getBloodCoffeeContent() > 0) {
			spicyMike.useRestroom();
		}
		
		while (spicyMike.getHydration() < 100) {
			spicyMike.drinkWater();
		}
		assertTrue(spicyMike.getHydration() == 100);
		
		while (spicyMike.getBloodAlcoholContent() > 0 
				|| spicyMike.getBloodCoffeeContent() > 0) {
			spicyMike.useRestroom();
		}
		
		while (spicyMike.getBloodCoffeeContent() < 100) {
			spicyMike.drinkCoffee();
		}
		spicyMike.getToxicology();
		assertTrue(spicyMike.getBloodCoffeeContent() == 100);
		
		while (spicyMike.getBloodAlcoholContent() > 0 
				|| spicyMike.getBloodCoffeeContent() > 0) {
			spicyMike.useRestroom();
		}
		
		while (spicyMike.getHydration() < 100) {
			spicyMike.drinkWater();
		}
		assertTrue(spicyMike.getHydration() == 100);
		
		System.out.println(spicyMike.getQuote());
	}
	
	

}
