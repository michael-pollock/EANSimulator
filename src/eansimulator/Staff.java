package eansimulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Staff {
	private int numOfStaff = 14;
	Employee player = new Employee("No Name");
	Employee michael = new Employee("Madman Mike");
	Employee jack = new Employee("Evil Jack the Help Agent");
	Employee robert = new Employee("Robert the Cowboy");
	Employee kira = new Employee("Killer Kira");
	Employee lauren = new Employee("My Wife");
	Employee mads = new Employee("Mads the Mad Billing Agent");
	Employee amanda = new Employee("Equipped Amanda");
	Employee audrey = new Employee("Sly Audrey");
	Employee corey = new Employee("Cool Hand Corey");
	Employee bill = new Employee("Badger Bill");
	Employee chris = new Employee("King Christopher Lewistopher");
	Employee ben = new Employee("Ghost Ben");
	Employee tate = new Employee("Ghost Tate");
	Employee andrew = new Employee("Andrew");
	Employee garrett = new Employee("Army Garrett");

	public Staff() throws IOException {
		List<String> michaelQuotes = importQuotes("michaelQuotes.txt");
		for (String eachQuote : michaelQuotes) {
			michael.addQuote(eachQuote);
		}

	}

	public static List<String> importQuotes(String fileName) throws IOException {
		return Stream.quotes(fileName);
	}
	
	public String quoteLottery() {
		//int choice = Task.randomIntGen(numOfStaff);
		int choice = 0; // necessary until other employees have quotes added
		switch (choice) {
		case 0:
			return michael.getQuote();
		case 1:
			return robert.getQuote();
		case 2:
			return kira.getQuote();
		case 3:
			return lauren.getQuote();
		case 4:
			return mads.getQuote();
		case 5:
			return amanda.getQuote();
		case 6:
			return audrey.getQuote();
		case 7:
			return corey.getQuote();
		case 8:
			return bill.getQuote();
		case 9:
			return chris.getQuote();
		case 10:
			return ben.getQuote();
		case 11:
			return tate.getQuote();
		case 12:
			return andrew.getQuote();
		case 13:
			return andrew.getQuote();
		}
		return "Something went wrong.";
	}

}
