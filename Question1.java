import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Reads numbers from a file named data.dat and writes them to a file
 *
 */
public class Question1 {

	public static void main(String[] args) {

		HashSet<String> notVoted = new HashSet<>();
		HashMap<String, Integer> voted = new HashMap<>();
		String[] candidates = { "Ariana", "Jess", "Tara" };
		Scanner keyboard = new Scanner(System.in); // For user input
		System.out.println("Enter name for input file with voter names:");
		String fileoption = keyboard.nextLine();
		try (Scanner file = new Scanner(new File(fileoption))) {
			while (file.hasNextLine()) { // Read until end-of-file.
				String name = file.nextLine();
				notVoted.add(name);
			}
			file.close();
		} catch (FileNotFoundException e) {
			// Can be caused if file does not exist or can't be read.
			System.out.println("Can't open input file " + fileoption);
			System.out.println("Error: " + e);
			return; // Return from main(), since an error has occurred.
		}

		System.out.println("Enter your name ");
		String voter = keyboard.nextLine();
		while (!voter.equals("12345")) {
			if (notVoted.contains(voter)) {
				notVoted.remove(voter);
				System.out.println("Choose the following candidates: ");
				for (int i = 0; i < 3; i++) {
					System.out.println(i + ": " + candidates[i]);
				}
				System.out.println("Enter your choice: ");
				Integer choice = keyboard.nextInt();
				String temp = keyboard.nextLine(); // Skip extra /n
				voted.put(voter, choice);
				System.out.println("Enter your name ");
				voter = keyboard.nextLine();
			} else {
				System.out.println("Sorry. There is an error. Please speak to a staff member. ");
				System.out.println("Enter your name ");
				voter = keyboard.nextLine();
			}

		}

		// Write the data to the output file.
		System.out.println("Enter name for output file of voting data: ");
		String outputFile = keyboard.nextLine();
		try (PrintWriter result = new PrintWriter(outputFile)) {
			for (String key : voted.keySet()) {
				Integer vote = voted.get(key);
				result.println(key + " " + vote);

			}
			result.close();

		} catch (FileNotFoundException e) {

			System.out.println("Can't open file result.dat!");
			System.out.println("Error: " + e);
		}

		keyboard.close();
		System.out.println("DONE!");

	} // end of main()

} // end class ReverseFileWithTextReader