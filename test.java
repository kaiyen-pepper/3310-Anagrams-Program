import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// try-catch for opening input file
		try {
			// Scanner inputScanner takes in words from input file
			File input = new File("words.txt");
			Scanner inputScanner = new Scanner(input);
			
			// iterate through input file for words and add them to anagrams set
			while (inputScanner.hasNextLine()) {
				// Scanner only scans in alphabetical characters of each word
				String word = inputScanner.nextLine().replaceAll("[^a-zA-Z\\p{L}]", "").toLowerCase();
				System.out.println(word);
			}
			inputScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}
	}

}
