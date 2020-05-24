import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 *
 */
public class Question2 {

	public static void main(String[] args) {

		HashSet<String> filesUsed = new HashSet<>();
		int[] voteCount = new int[3];

		Scanner keyboard = new Scanner(System.in); // For user input
		System.out.println("Enter name for input file with vote data (or quit) :");
		String filename = keyboard.nextLine();
		while (!filename.equals("quit")) {
			if (filesUsed.contains(filename)) {
				System.out.println("Sorry. That file has already been analyzed.");
			} else {
				try (Scanner inFile = new Scanner(new File(filename))) {

					filesUsed.add(filename);
					while (inFile.hasNext()) {
						String name = inFile.next();
						int vote = inFile.nextInt();
						voteCount[vote]++;
					}
					inFile.close();
				} catch (FileNotFoundException e) {
					System.out.println("Can't find the file");
				}

			}
			System.out.println("Enter name for input file with vote data (or quit) :");
			filename = keyboard.nextLine();

		}
		for (int i = 0; i < voteCount.length; i++) {
			System.out.println("Candidate #" + i + " count : " + voteCount[i]);
		}

	} // end of main()

} // end class