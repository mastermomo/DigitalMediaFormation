

/**
 * @author Mohammad Khan
 * @version 1.0
 * 
 * This class process information provided about songs
 * and images into an easy to read format.
 */

import java.io.*;
import java.util.*;

public class MediaListFormation {
	public MediaListFormation() {

	}
	/*
	 * Dialogue that asks the user to input their file if not done so. 
	 * @return A string asking the user to input their file.
	 */
	private static String promptForFileName() {
		return "Please input you're file";

	}
	// Opens the file in question and formats the information if file is formatted correctly.
	public void openFile(ArrayList<GeneralDigitalMedia> digitMed, String openingFile) {
		String text; // A variable representing each line of text.
		Scanner scan = null; //A scanner object ready to read the file.
		
		// try-catch block
		try {
			scan = new Scanner(new File(openingFile)); // File opened for reading

			//Reads and puts each line of text into an DigitalMedia 
			//array until no more lines of text exist.
			while (scan.hasNext()) {

				text = scan.nextLine(); // reads the text of the file.
				String infoDivide[] = text.split(":"); // Splits each piece of every line using ":" in the file.
				infoDivide[0] = infoDivide[0].trim(); // Trims excess space in eacch piece of the every line.

				// Sees if the first piece of each line has "S" or "s"
				if (infoDivide[0].equals("S") || infoDivide[0].equals("s")) {
					digitMed.add(new SongConverter(infoDivide[1], Long.parseLong(infoDivide[4].trim()), infoDivide[3], infoDivide[2])); // Makes the object using the constructor of the Song class and adds it to the array.
				} 
				//Sees if the first piece of each line has "I" or "i"
				else if (infoDivide[0].equals("I") || infoDivide[0].equals("i")) {
					digitMed.add(new ImageConverter(infoDivide[1], Long.parseLong(infoDivide[4].trim()),
							Integer.parseInt(infoDivide[3].trim()), Integer.parseInt(infoDivide[2].trim()))); // Makes the object using the constructor of the Image class and adds it to the array.
				} 
				// Makes sure that the file used has the correct format.
				else {
					System.out.println("The media you have provided is not correct.");
				}
			}
			// The file is closed.
			scan.close();
		}
		// A catch block to handle FileNotFoundException
		catch (FileNotFoundException e) {
			e.printStackTrace();

			System.err.println("Not able to open your file.");
		}

	}
 
	// Provides the input options available to users. 
	public static void displayOptions() {
		System.out.println("Select from one of the following options by entering the character" + "\nspecified:"
				+ "\n\tPress S to display a list of all the songs." + "\n\tPress I to display a list of all the images."
				+ "\n\tPress Q to quit the program.");
	}

	// Prints required information for assignment.
	private static void printHeading() {
		System.out.println("Mohammad Abdul Ahad Khan");
		System.out.println("Project 1");
		System.out.println("CMSC 256");
		System.out.println("Spring 2019");
	}
	
	// Main method used for program execution.
	public static void main(String[] args) {
		
		// Creates objects of class MediaList.
		MediaListFormation prompt = new MediaListFormation();
		MediaListFormation printHead = new MediaListFormation();
		MediaListFormation display = new MediaListFormation();
		MediaListFormation openFileNow = new MediaListFormation();
		
		ArrayList<GeneralDigitalMedia> digitMed = new ArrayList<GeneralDigitalMedia>(); //An array list created to for DigitalMedia class
		Scanner scan = new Scanner(System.in); // Creates an object of the Scanner class.

		String letterInput; // String variable to be used on "scan" object.
		boolean tagForQ = true;

		printHead.printHeading(); // Prints the required information for the assignment.
		System.out.println("");
		System.out.println(prompt.promptForFileName()); // Prints a string asking to put in the correct file if not done so.

		openFileNow.openFile(digitMed, args[0]); // Opens the file a user has put in. 

		display.displayOptions(); // Prints the options available to the user.
		letterInput = scan.nextLine(); // Scans the users string input.

		// Checks to to see what the user typed as the input. 
		//If "Q" or "q" is entered, the program terminates.
		while (tagForQ == true) {
			// If the user inputs "S" or "s", the program prints out all songs in the file.
			if (letterInput.equals("s") || letterInput.equals("S")) {
				for (int i = 0; i < digitMed.size(); i++) {
					if (digitMed.get(i) instanceof SongConverter) {
						System.out.println(digitMed.get(i));
					}
				}
			} 
			// If the user inputs "I" or "i", the program prints out all images in the file.
			else if (letterInput.equals("i") || letterInput.equals("I")) {
				for (int i = 0; i < digitMed.size(); i++) {
					if (digitMed.get(i) instanceof ImageConverter) {
						System.out.println(digitMed.get(i));
					}
				}
			}
			// Sets the while loop to false and terminates the program when "Q" or "q" is entered.
			else if (letterInput.equals("Q") || letterInput.equals("q")){
				tagForQ = false;
				System.out.println("You have entered Q. The program is now terminated.");
			}
			// If the user presses any key other than "Q", "q", "S", "s", "I", "i" then
			// a response indicating as such is given.
			else if (!(letterInput.equals("S")) || !(letterInput.equals("s")) || !(letterInput.equals("I")) || !(letterInput.equals("i"))) {
				System.out.println("You did not enter any of the possible inputs.");
			}
			letterInput = scan.nextLine(); // Accepts next input in the while loop.
		}
	}
}