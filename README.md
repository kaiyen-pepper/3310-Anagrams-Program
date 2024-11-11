# Anagram Finder

This Java program reads a list of words from an input file and groups them into sets of anagrams. The output of this program is a file named `output.txt` that lists a word and all its associated anagrams.

## How It Works
1. **Input**: The program takes the path of an input file as a command-line argument. The input file should contain one word per line.
2. **Processing**:
   - The program normalizes input by removing non-alphabetical characters and converting to lowercase. 
   - Words considered for anagrams are at least two characters long. Example: "at" can have the anagram "ta".
   - It sorts the word's characters alphabetically and uses this sorted string as a key to group anagrams.
   - If a key does not exist in our anagram set, add the key and its original unsorted word to set.
   - If multiple words share the same sorted string, they are considered anagrams and added to their lists at their respective keys.
3. **Output**: After processing all the words, the program writes the anagram groups to a file named `output.txt`. Each group is formatted as:
   ```
   word: [anagram1, anagram2, ...]
   ```

## Requirements
- Java 8 or later.
- An input text file with words (one word per line).
- Terminal or Windows Command Line.

## Usage

1. Compile the Java program:
   ```
   javac Anagram.java
   ```
2. Run the program, passing the path to the input file as an argument:
   ```
   java Anagram words.txt
   ```
3. The program will process the input file, find anagram groups, and write them to `output.txt`.

## Example

**Input File (`input.txt`):**
```
eat
tea
tan
ate
nat
bat
```

**Output File (`output.txt`):**
```
eat: [tea, ate]
tan: [nat]
```

## Error Handling
- If the input file is not found, the program will print an error message.
- If there is an issue with file writing (e.g., permissions), the program will print an appropriate error message.

## Code Explanation

### Main Method

1. **SortedMap for Anagrams**:
   - A `SortedMap<String, LinkedList<String>>` is used to store the anagram groups. The key is a sorted version of the word, and the value is a list of words (anagrams) that match this key.

2. **Input File Processing**:
   - The program uses a `Scanner` to read the input file. Each word is cleaned by removing non-alphabetical characters and converting it to lowercase.
   - For non-English alphabetical characters (i.e. étude), this program uses the following regular expression to read in Unicode letters:  `"[\\p{L}]"`. The program does not convert non-ASCII letters to ASCII letters.
   - The word is then sorted alphabetically, and the sorted word is used as the key to group anagrams.

3. **Writing to Output File**:
   - The program opens `output.txt` for appending.
   - It iterates through the sorted map of anagrams and writes the results to the output file, only including groups with more than one word (true anagram groups).
   
4. **Error Handling**:
   - The program includes `try-catch` blocks to handle `FileNotFoundException` and `IOException`.
