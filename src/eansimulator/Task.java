package eansimulator;

import java.io.IOException;
import java.util.Scanner;

public class Task {
	Scanner sc = new Scanner(System.in);
	Staff staff = new Staff();
	int dailyTickets = 5;
	int currentTicket = 0;
	Ticket[] ticket = new Ticket[dailyTickets];
	boolean endGame;
	
	
	public Task() throws IOException {
		for (int ticketNum = 0; ticketNum < dailyTickets; ++ticketNum) {
			ticket[ticketNum] = new Ticket();
		}
		introduction();
		opening();
		openingResponse();
		while (currentTicket <= dailyTickets && !endGame) {
			prompt();
			promptResponse();
		}
	}
	
	public void introduction() {
		System.out.println("What is your name?");
		String name = sc.nextLine();
		staff.player.setName(name);
	}
	
	public static void opening() {
		System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println("|           EAN SIMULATOR 2021         |");
		System.out.println("|                                      |");
		System.out.println("|           Press 1 to WORK            |");
		System.out.println("|           Press 2 to COME IN LATE    |");
		System.out.println("|           Press 3 to CALL IN SICK    |");
		System.out.println("|           Press 4 to QUIT            |");
		System.out.println("|                                      |");
		System.out.println("|   Brought to you by Michael Pollock  |");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
	}
	
	public void openingResponse() {
		int choice = validInt(1, 4);
		switch (choice) {
		case 1: 
			System.out.println("\nYou woke up at a respectable hour and feel ");
			System.out.println("like a respectable person. ");
			System.out.println("You will go far in life with these traits.");
			break;
		case 2: 
			System.out.println("\nYou're late and you feel a little bit guilty.");
			staff.player.setHungry(true);
			break;
		case 3:
			System.out.println("\nFeel better soon and please don't die.");
			endGame = true;
			break;
		case 4:
			endGame = true;
			System.out.println("\nYou have quit for unknown reasons and are full of regret.");
			break;
		}
	}
	
	public void prompt() {
		if (staff.player.getStaffedIn()) {
			System.out.println("\nPress 0 to AUX OUT ");
		} else {
			System.out.println("\nPress 0 to STAFF IN ");
		}
		System.out.println("Press 1 to CONSULT RIBBERT ");
		System.out.println("Press 2 to TALK TO A RANDOM COWORKER ");
		System.out.println("Press 3 to SEE FOOD/DRINK OPTIONS ");
		System.out.println("Press 4 to DRAW ON THE WINDOWS ");
		System.out.println("Press 5 to PLAY THE SIMS ");
		System.out.println("Press 6 to DO SOME PUSHUPS ");
		System.out.println("Press 7 to SUMMON THE BADGER ");
		System.out.println("Press 8 to WORK ON A TICKET ");
	}
	
	public void promptResponse() {
		int choice = validInt(0, 8);
		switch (choice) {
		case 0: 
			staff.player.swapAvailability();
			System.out.println("\nbeep beep beep");
			break;
		case 1: 
			System.out.println("\nAsk Ribbert any question you like and he will answer it for you. ");
			String question = sc.nextLine();
			System.out.println("\nYou asked Ribbert the following question: ");
			System.out.println(question);
			System.out.println("Here is his answer: ");
			System.out.println("Human Error.");
			break;
		case 2: 
			System.out.println(staff.quoteLottery());
			break;
		case 3: 
			foodAndDrinkPrompt();
			foodAndDrinkResponse();
			break;
		case 4:
			System.out.println("\n"+staff.chris.getName()+": Who drew ANOTHER cat butt on the window?!");
			break;
		case 5:
			System.out.println("\nThe sims are not doing well and everything is on fire.");
			break;
		case 6:
			System.out.println("\nThe backrow boys have drafted you into their club.");
			break;
		case 7:
			//staff.bill.getQuote();
			System.out.println("\n*Badger enters and leans against the window*");
			System.out.println("It's amazing. You think about all the people in the world, ");
			System.out.println("and how nice it would be");
			System.out.println("to be on a beach without any of them being there.");
			break;
		case 8:
			if (staff.player.getStaffedIn() == false) {
				System.out.println("\nYou're not staffed in. Do you really want to work");
				System.out.println("without being on the clock?");
				System.out.println("This is a rhetorical question. Please staff in before taking tickets.");
				break;
			}
			System.out.println("\nYou are working on ticket number "+ (currentTicket+1)+" out of "+(dailyTickets-1));
			ticket[currentTicket] = new Ticket();
			ticket[currentTicket].prompt();
			while (!ticket[currentTicket].isSolved() && ticket[currentTicket].getActionNum() < 5 
					&& !ticket[currentTicket].getFailed()) {
				if (ticket[currentTicket].getActionNum() > 0) {
					System.out.println("\nStill not werkin'. What do I do next?");
				}
				ticket[currentTicket].promptResponse();
			}
			if (!ticket[currentTicket].isSolved()) {
				System.out.println("\nThe customer is furious and has hung up.");
			} else {
				System.out.println("\nMy internet is working again! Woohoo!");
			}
			incrementTicket();
			break;
		}
	}
	
	public void foodAndDrinkPrompt() {
		System.out.println("\nPress 1 to DRINK WATER ");
		System.out.println("Press 2 to DRINK COFFEE ");
		System.out.println("Press 3 to DRINK BEER ");
		System.out.println("Press 4 to DRINK TEQUILA ");
		System.out.println("Press 5 to EAT A BAGEL ");
	}
		
	public void foodAndDrinkResponse() {
		int choice = validInt(1,5);
		switch (choice) {
		case 1:
			staff.player.drinkWater();
			break;
		case 2:
			staff.player.drinkCoffee();
			break;
		case 3:
			staff.player.drinkBeer();
			break;
		case 4:
			staff.player.drinkTequila();
			break;
		case 5: 
			staff.player.ateSnack();
			break;
		}
	}
	
	public static int validInt(int lowestChoice, int highestChoice) {
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		while (choice < lowestChoice || choice > highestChoice) {
			System.out.println("Please make a selection between "+lowestChoice
					+ " and " + highestChoice + ". ");
			choice = sc.nextInt();
		}
		return choice;
	}
	
	public void incrementTicket() {
		if (currentTicket < dailyTickets - 2) {
			++currentTicket;
		} else {
			System.out.println("Well, looks like it's time to go home!");
			System.out.println("*You exit passing a group of people waiting for help*");
			endGame = true;
		}
	}
	
	public static int randomIntGen(int topPossible) {
		return (int)(Math.random()*(topPossible));
	}
}
