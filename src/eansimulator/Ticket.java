package eansimulator;

import java.util.Scanner;

public class Ticket {
	private boolean solved;
	private boolean failed;
	private boolean broken;
	private boolean pluggedInCorrectly;
	private boolean needsRestart;
	private boolean simConnected;
	private int heightRequired; 
	private int heightActual;
	private int headingRequired;
	private int headingActual;
	private int customerHonesty;
	private int actionNum;
	
	public Ticket() {
		actionNum = 0;
		broken = randomBoolean();
		pluggedInCorrectly = randomBoolean();
		needsRestart = randomBoolean();
		simStatus();
		heightRequired = randomHeight();
		headingRequired = randomHeading();
		customerHonesty = 115 - heightRequired;
		heightActual = randomHeightActual();
		headingActual = randomHeadingActual();
	}
	
	public Ticket(boolean broken, boolean pluggedInCorrectly, boolean needsRestart,
			boolean simConnected, int heightRequired, int headingRequired, 
			int customerHonesty, int heightActual, int headingActual) {
		actionNum = 0;
		this.broken = broken;
		this.pluggedInCorrectly = pluggedInCorrectly;
		this.needsRestart = needsRestart;
		this.simConnected = simConnected;
		this.heightRequired = heightRequired;
		this.headingRequired = headingRequired;
		this.customerHonesty = customerHonesty;
		this.heightActual = heightActual;
		this.headingActual = headingActual;
	}
	
	public boolean randomBoolean() {
		return Math.random() < 0.5;
	}
	
	public int randomHeight() {
		return (int)(Math.random()*100 + 15);
	}
	
	public int randomHeightActual() {
		if (heightRequired < 50 && randomBoolean()) {
			return heightRequired;
		} else {
			return heightRequired - customerHonesty;	
		}
	}
	
	public int randomHeading() {
		return (int)(Math.random()*360);
	}
	
	public int randomHeadingActual() {
		if (Math.random() > .2) {
			return headingRequired;
		} else {
			return randomHeading();
		}
	}
	
	public void simStatus() {
		if (!needsRestart && pluggedInCorrectly) {
			simConnected = true;
		}
	}
	
	public void plugInCorrectly() {
		pluggedInCorrectly = true;
	}
	
	public void restart() {
		needsRestart = false;
	}
	
	public void raise(int newHeight) {
		if (customerHonesty < 50) {
			heightActual += newHeight - 10;
		} else {
			heightActual = newHeight;
		}
	}
	
	public void rotate() {
		headingActual = headingRequired;
	}
	
	public void replace() {
		broken = false;
	}
	
	public int getHeight() {
		return heightActual;
	}
	
	public void getStats() {
		System.out.println("Broken: "+broken);
		System.out.println("Plugged In Correctly: "+pluggedInCorrectly);
		System.out.println("Needs Restart: "+needsRestart);
		System.out.println("Sim Connected: "+simConnected);
		System.out.println("Height Required: "+heightRequired);
		System.out.println("Height Actual: "+heightActual);
		System.out.println("Heading Required: "+headingRequired);
		System.out.println("Heading Actual: "+headingActual);
		System.out.println("Customer Honesty: "+customerHonesty);
	}
	
	public void getPublicStats() {
		System.out.println("\nSim Connected: "+simConnected);
		System.out.println("Height Required: "+heightRequired);
		System.out.println("Heading Required: "+headingRequired);
	}
	
	public void getSetup() {
		System.out.println("\nHeight: "+heightActual);
		System.out.println("Heading: "+headingActual);
		
	}
	
	public boolean isSolved() {
		if (!broken && simConnected && heightRequired <= heightActual
				&& headingRequired == headingActual) {
			solved = true;
		}
		return solved;
	}
	
	public void prompt() {
		System.out.println("\nPress 0 to VIEW SETUP REQUIREMENTS");
		System.out.println("Press 1 to CHECK ACTUAL HEIGHT/HEADING");
		System.out.println("Press 2 to FIX ETHERNET CABLE SETUP");
		System.out.println("Press 3 to RESTART");
		System.out.println("Press 4 to RAISE");
		System.out.println("Press 5 to ROTATE");
		System.out.println("Press 6 to REPLACE");
		System.out.println("Press 7 to GIVE UP");
		System.out.println("Press 8 to GENERATE YOUR OWN RESPONSE");
		System.out.println("Press 9 to REPRINT PROMPTS");
	}
	
	public int getActionNum() {
		return actionNum;
	}
	
	public boolean getFailed() {
		return failed;
	}
	
	public void promptResponse() {
		int choice = Task.validInt(0,9);
		if (choice > 0 && choice < 7 ) {
			++actionNum;
		}
		switch (choice) {
		case 0:
			getPublicStats(); break;
		case 1: 
			getSetup();
			if (heightActual == heightRequired && headingActual == headingRequired) {
				System.out.println("\nMy setup is fine!");
			} else {
				System.out.println("\nMy setup has always worked in the past.");
			} break;
		case 2: 
			if (pluggedInCorrectly) {
				System.out.println("\nIt's plugged in the same it's always been.");
			} else {
				System.out.println("\nAhh, whaa, ooo, I gotta move the desk.. here we go I got it now.");
			}
			plugInCorrectly(); 
			simStatus();
			break;
		case 3: 
			if (!needsRestart) {
				System.out.println("\nI've already restarted it a bunch of times.");
			} else {
				System.out.println("\nRestart it? Ehhhhhhh idk how.");
				System.out.println("\n*You tell them how and they do it correctly*");
			}
			restart(); 
			simStatus();
			break;
		case 4:
			if (heightActual >= heightRequired) {
				System.out.println("\nIt's already wayyyy up there I think. It's at "+heightActual+" feet!");
				break;
			} else if (heightRequired >= 50){
				System.out.println("\nI'm gonna have to rent a bucket truck to get it any higher!");
			}
			System.out.println("\nHow high do I need to mount it? ");
			raise(Task.validInt(0, 100000)); 
			break;
		case 5: 
			if (headingActual == headingRequired) {
				System.out.println("\nThere's no way it rotated. I have that sucker locked down. "
						+ "It's pointed at "+headingActual+" degrees.");
			} else {
				System.out.println("\nHeading? The what? oh. I need a compass? I don't have a compass. I'll do my best.");
			}
			rotate(); 
			break;
		case 6: 
			System.out.println("\n*You read the terms and conditions and they agreed to them.*");
			replace(); 
			break;
		case 7: 
			System.out.println("\n*You have officially given up*");
			failed = true; 
			break;
		case 8:
			++actionNum;
			Scanner sc = new Scanner(System.in);
			System.out.println("\nWhat would you like to say to the customer?");
			String reponse = sc.nextLine();
			System.out.println("\nYou tell the customer: \""+ reponse+"\"."); 
			System.out.println("They respond: Me \""+ reponse+"\"?! You \""+ reponse+"\"!!."); 
			break;
		case 9:
			prompt(); break;
		}
	}

}
