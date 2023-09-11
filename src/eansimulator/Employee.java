package eansimulator;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private int charisma;
	private int calmness;
	private int effectiveness;
	private int resilience;
	private int hostility;
	private int lifePathNumber;
	private int artisticAbility;
	private int bloodAlcoholContent;
	private int bloodCoffeeContent;
	private int hydration;
	private List<String> quote;
	
	private boolean hungry;
	private boolean staffedIn;

	public Employee(String aName) {
		name = aName;
		charisma = generateValue(10);
		calmness = generateValue(10);
		effectiveness = generateValue(10);
		resilience = generateValue(10);
		hostility = generateValue(10);
		lifePathNumber = generateValue(33);
		artisticAbility = generateValue(10);
		bloodAlcoholContent = 0;
		bloodCoffeeContent = 0;
		hydration = 100;
		quote = new ArrayList<String>();
	}
	
	public void swapAvailability() {
		staffedIn = !staffedIn;
	}
	
	public boolean getStaffedIn() {
		return staffedIn;
	}

	public int generateValue(int valueSize) {
		return (int) (1 + Math.random() * valueSize);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String aName) {
		name = aName;
	}

	public void calcHydration() {
		hydration = 100 - (bloodCoffeeContent + bloodAlcoholContent);
		if (hydration < 0) {
			System.out.println("\nYou have consumed too many liquids and you must now use the restroom.");
		}
	}

	public boolean canDrink() {
		if (hydration <= 0) {
			System.out.println("\nYou need to drink some water.");
			hydration = 0;
			return false;
		}
		return true;
	}
	
	public void setHungry(boolean choice) {
		hungry = choice;
	}
	
	public void ateSnack() {
		hungry = false;
	}

	public void drinkWater() {
		if (bloodAlcoholContent < 0) {
			bloodAlcoholContent = 0;
		}
		if (bloodCoffeeContent < 0) {
			bloodCoffeeContent = 0;
		}
		if (hydration >= 97) {
			bloodAlcoholContent = 0;
			bloodCoffeeContent = 0;
			hydration = 0;
		}
		if (bloodCoffeeContent >= 3) {
			bloodCoffeeContent -= 3;
		} else if (bloodAlcoholContent >= 3) {
			bloodAlcoholContent -= 3;
		} else {
			System.out.println("\nYou are now well hydrated.");
		}
		calcHydration();
	}

	public void drinkCoffee() {
		if (canDrink()) {
			if (bloodCoffeeContent <= 97) {
				bloodCoffeeContent += 3;
			} else if (bloodCoffeeContent > 97) {
				bloodCoffeeContent = 100;
			} else {
				System.out.println("\nYour Blood Coffee Content is already 100%. Please consider drinking some water.");
			}
			calcHydration();
		}
	}

	public void drinkBeer() {
		if (canDrink()) {
			if (bloodAlcoholContent >= 95) {
				bloodAlcoholContent = 100;
			} else {
				bloodAlcoholContent += 5;
			}
			if (bloodAlcoholContent == 100) {
				System.out.println("\nYour Blood Alcohol Content is now 100%. Please consider drinking some water.");
			}
			calcHydration();
		}
	}

	public void drinkTequila() {
		if (canDrink()) {
			if (bloodAlcoholContent >= 91) {
				bloodAlcoholContent = 100;
			} else {
				bloodAlcoholContent += 10;
			}
			if (bloodAlcoholContent == 100) {
				System.out.println("\nYour Blood Alcohol Content is now 100%. Please consider drinking some water.");
			}
			calcHydration();
		}
	}

	public void useRestroom() {
		if (bloodAlcoholContent > 0) {
			bloodAlcoholContent -= 5;
		}
		if (bloodAlcoholContent < 0) {
			bloodAlcoholContent = 0;
		}
		if (bloodCoffeeContent > 0) {
			bloodCoffeeContent -= 5;
		}
		if (bloodCoffeeContent < 0) {
			bloodCoffeeContent = 0;
		}

	}

	public int getBloodAlcoholContent() {
		return bloodAlcoholContent;
	}

	public int getBloodCoffeeContent() {
		return bloodCoffeeContent;
	}

	public int getHydration() {
		return hydration;
	}

	public void getToxicology() {
		System.out.println("\nBlood Coffee Content: " + bloodCoffeeContent + "%");
		System.out.println("Blood Alcohol Contnet: " + bloodAlcoholContent + "%");
		System.out.println("Hydration Level: " + hydration + "%");
	}
	
	public void addQuote(String phrase) {
		quote.add(phrase);
	}
	
	public String getQuote() {
		if (quote.size() == 0) {
			return "\nSorry, no quotes here!";
		} else {
			int randomQuote = (int)(Math.random()*quote.size());
			return name + ": " + quote.get(randomQuote);
		}
	}

}
