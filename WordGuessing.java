/**
 * We read text from a text file and then prompt the user to guess a word that is in the file, if the word is correct, then exit
 * the program. If not, display some necessary information
 * 
 * @author Lokesh Narasimhan
 * @version 11/06/2025
 *
 */

// import all of the necessary libraries required for the project
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordGuessing {

    /**
     * Takes a filename as input. Reads a list of words from the file into a
     * list and returns the list. Ensures that all of the words in the list are
     * in UPPERCASE (i.e. transforms lowercase letters to uppercase before
     * adding them to the list). Assumes that the file will be correctly
     * formatted with one word per line (though there may be blank lines with
     * no words on them). If the file cannot be read prints the
     * error message "ERROR: File fname not found!" where "fname" is the name of
     * the file and returns an empty list.  Note that the order of the words in the
     * list must be the same as the order of the words in the file to pass the
     * test cases.
     *
     * @param fname
     *            the name of the file to read words from
     * @return a list of words read from the file in all uppercase letters.
     */
    public static List<String> readWords(String fname){
        List<String> words = new ArrayList<String>(); // creates a list of strings

        // try-block, we use a bufferedreader object to read all the contents from the text file
        try(BufferedReader reader = new BufferedReader(new FileReader(fname))){
            String word;

            // loops until there is nothing to read from the file
            while((word = reader.readLine()) != null){ 
                if(!word.isEmpty()){
                    words.add(word.toUpperCase()); // appends the word to the list.
                }
            }
            System.out.println("Read " + words.size() + " words from the file.");
        }
        catch(IOException e){
            System.out.println("ERROR: File " + fname + " not found!"); // prints this message if the file is not found
        }

        return words; // returns the list words
    }

    /**
     * Takes a Random object and a list of strings and returns a random String
     * from the list. Note that this method must not change the list.  The list
     * is guaranteed to have one or more elements in it.
     *
     * @param rnd
     *            Random number generator object
     * @param inList
     *            list of strings to choose from
     * @return an element from a random position in the list
     */
    public static String getRandomWord(Random rnd, List<String> inList) {
        int index = rnd.nextInt(inList.size()); // creates an int variable to hold the index of the random word
        String randomWord = inList.get(index); // assigns the randomWord variable the random Word 
        return randomWord; // returns the random word
    }

    /**
     * Given a String, returns a StringBuilder object that is the same length
     * but is only '*' characters. For example, given the String DOG as input
     * returns a StringBuilder object containing "***".
     *
     * @param inWord
     *            The String to be starred
     * @return a StringBuilder with the same length as inWord, but all stars
     */
    public static StringBuilder starWord(String inWord) {
        StringBuilder sb = new StringBuilder(); // creates a stringbuilder object 'sb'
        int wordLen = inWord.length(); // returns the length of the string which is passed as the parameter
        StringBuilder starReplaced = sb.repeat("*", wordLen); // this code repeats the '*' as many times as the length of the string.
        return starReplaced; // returns the star replaced sequence
    }

    /**
     * Prompts the user to enter a single character. If the user enters a blank
     * line or more than one character, give an error message as given in the
     * assignment and prompt them again. When the user enters a single
     * character, return the uppercase value of the character they typed.
     *
     * @param inScanner
     *            A scanner to take user input from
     * @return the uppercase value of the character typed by the user.
     */
    public static char getCharacterGuess(Scanner inScanner) {
        while(true) {
            System.out.print("Enter a character to guess: ");
            String input = inScanner.nextLine(); // Read once and store
            
            if (input.equals("") || input.length() > 1) {
                System.out.println("ERROR: Enter a single character that is not null"); // error prompt
            }
            else {
                String chr = input.toUpperCase(); // converts the input to uppercase
                char realChr = chr.charAt(0); // extracts the char from the string
                return realChr; // Return inside the else block
            }
        }
    }

    /**
     * Count the number of times the character ch appears in the String word.
     *
     * @param ch
     *            character to count.
     * @param word
     *            String to examine for the character ch.
     * @return a count of the number of times the character ch appears in the
     *         String word
     */
    public static int charCount(char ch, String word) {
        int count = 0; // initializes a count variable to keep track of the number of times a character repeats

        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ch){
                count++;
            }
        }

        return count;
    }

    /**
     * Modify the StringBuilder object starWord everywhere the char ch appears
     * in the String word. For example, if ch is 'G', word is "GEOLOGY", and
     * starWord is "**O*O*Y", then this method modifies starWord to be
     * "G*O*OGY".  Your code should assume that word and starWord are
     * the same length.
     *
     * @param ch
     *            the character to look for in word.
     * @param word
     *            the String containing the full word.
     * @param starWord
     *            the StringBuilder containing the full word masked by stars.
     */
    public static void modifyStarWord(char ch, String word, StringBuilder starWord) {
        // for-loop to iterate through the string and replace all the stars with the character
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i)==ch){
                starWord.setCharAt(i, ch); // replaces all the stars with the specific character
            }
        }
    }
 
    /**
     * Checks if the character has already been guessed by looking through the list
     * of previously guessed characters.
     * 
     * @param guessedList - the list of previously guessed characters
     * @param guess - the character to check
     * @return true if character has been guessed before, false otherwise
     */
    public static boolean isAlreadyGuessed(ArrayList<Character> guessedList, char guess) {
        return guessedList.contains(guess);
    }
    
    /**
     * Handles the rematch prompt and validates user input.
     * Only accepts 'Y', 'y', 'N', or 'n' as valid inputs.
     * 
     * @param inScanner - Scanner object to read user input
     * @return true if user wants a rematch (Y/y), false if not (N/n)
     */
    public static boolean askForRematch(Scanner inScanner) {
        while(true) {
            System.out.print("Would you like a rematch [Y/N]?: ");
            String response = inScanner.nextLine();
            
            if(response.equalsIgnoreCase("Y")) {
                return true;
            }
            else if(response.equalsIgnoreCase("N")) {
                return false;
            }
            else {
                System.out.println("Please enter only a Y or an N.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // creates a scanner object

        System.out.print("Enter a random seed: "); // prompts the user for input for the random seed
        int seed = Integer.parseInt(in.nextLine()); // inputs the seed
        Random rnd = new Random(seed); // create Random object with seed

        System.out.print("Enter a filename for your wordlist: "); 
        String fName = in.nextLine(); // inputs the file name to read from

        List<String> words = readWords(fName); // calls the readWords method and stores the returned list
        
        // Check if file reading failed or no words were read
        if(words.isEmpty()) {
            System.out.println("No words read - exiting program!");
            System.out.println("Goodbye!");
            return;
        }

        boolean playAgain = true;

        while(playAgain) {
            String randomWord = getRandomWord(rnd, words); // calls the getRandomWord method
            StringBuilder starredWord = starWord(randomWord); // calls the starWord method
            ArrayList<Character> guessedChars = new ArrayList<>();
            int noOfGuesses = 0;
            boolean wordGuessed = false;

            while (!wordGuessed) {
                System.out.println("The word to guess is: " + starredWord); // prints out the starred word.
                System.out.println("Previous characters guessed: " + guessedChars);
                
                char guess = getCharacterGuess(in); // calls the getCharacterGuess method
                
                // Check if character was already guessed
                if(isAlreadyGuessed(guessedChars, guess)) {
                    System.out.println("You've already guessed " + guess + ". Try another character");
                    System.out.println();
                    continue; // Skip the rest and ask for another character
                }
                
                // Add the guess to the list
                guessedChars.add(guess);
                noOfGuesses++;
                
                int count = charCount(guess, randomWord);
                System.out.println("The character " + guess + " occurs in " + count + " positions.");
                System.out.println();

                modifyStarWord(guess, randomWord, starredWord); // calls the modifyStarWord method

                System.out.println("The word to guess is: " + starredWord);
                System.out.print("Enter your guess for the word: ");
                String guessWord = in.nextLine();

                if (!guessWord.equalsIgnoreCase(randomWord)) {
                    System.out.println("That is not the word.");
                    System.out.println();
                } 
                else {
                    System.out.println("Yes! " + randomWord + " is the correct word!");
                    System.out.println();
                    System.out.println("That took you " + noOfGuesses + " guesses.");
                    wordGuessed = true;
                    
                    playAgain = askForRematch(in);
                    System.out.println();
                }
            }
        }
        
        System.out.println("Goodbye!");
    }
}