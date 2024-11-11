/**********************************************************************/
/* Kaitlin Yen */
/* Login ID: 016414437 */
/* CS 3310, Fall 2024 */
/* Programming Assignment 2 */
/* Main Program Function: find anagrams and print them out in a file  */
/**********************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Anagram {
	
	public static void main(String[] args) {
		/****************************************************************/
		/* Method: main 											    */
		/* Purpose: given a text file find anagrams of each word line   */
		/* Prints: word & anagrams of that word							*/
		/* Parameters: N/A											    */
		/* Returns: void 												*/
		/****************************************************************/
		
		SortedMap<String, LinkedList<String>> anagrams = new TreeMap<>();
		
		// try-catch for opening input file
		try {
			// Scanner inputScanner takes in words from input file
			File input = new File(args[0]);
			Scanner inputScanner = new Scanner(input);
			
			// iterate through input file for words and add them to anagrams set
			while (inputScanner.hasNextLine()) {
				
				// Scanner only scans in alphabetical characters of each word
				String word = inputScanner.nextLine().replaceAll("[^a-zA-Z\\p{L}]", "").toLowerCase();
				if (word.length() >= 2) {
					
					// Sort word into alphabetical order to use as a key for anagrams
					char[] tempKey = word.toCharArray();
					Arrays.sort(tempKey); // eat --> aet
					String key = new String(tempKey);
					
					// If scanned word not already a key in anagram set, add its key
					// If scanned word already a key in anagram set, add word to list at index key
					if (anagrams.containsKey(key)) {
						if (!anagrams.get(key).contains(word)) {
							anagrams.get(key).add(word);	
						}
					} else {
						LinkedList<String> newWord = new LinkedList<>();
						newWord.add(word);
						anagrams.put(key, newWord);
					}					
				}
			}
			
			// open file output.txt to write anagrams
			File file = new File("output.txt");
			FileWriter writer;
	        writer = new FileWriter(file, true);
	        PrintWriter printer = new PrintWriter(writer);

	        // iterate through anagrams set to write to file
	        for (int i = 0; i < anagrams.size(); i++) {
	        	LinkedList<String> values = new LinkedList<>();
	        	String key = new String(anagrams.keySet().toArray()[i].toString());
	        	values = anagrams.get(key);
	        	if (values.size() >= 2) {
	        		printer.write(values.removeFirst() + ": " + values + "\n");
	        	} else {
	        		anagrams.remove(key);
	        		i--;
	        	}
	        }
	        	        
			// close printer when all anagrams are included in output.txt
			// close inputScanner when all of File input is read
			printer.close();
			inputScanner.close();
			
		}
		// catch file and output exceptions
		catch(FileNotFoundException e) {
			System.out.println(e.toString());
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}
