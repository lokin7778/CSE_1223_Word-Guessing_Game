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
import java.io.FileNotFoundException;
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

            // loops until theere is nothing to read from the file, we use null here to avoid the nullPointerException if 
            //.isEmpty() is used.
            int wordCount = 0; // added this variable to count the number of words in the file
            while((word = reader.readLine()) != null){ 
                if(!word.isEmpty()){
                    words.add(word.toUpperCase()); // appends the word to the list.
                    wordCount++;
                }
            }
            System.out.println("Read " + wordCount + " words from the file.");
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
        
        rnd = new Random(); // creates a new Random object 'rnd'
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
        
        System.out.print("Enter a character to guess: ");
        
        String input = inScanner.nextLine(); // Read once and store
        
        if (input.equals("") || input.length() > 1) {
            System.out.println("ERROR: Enter a single character that is not null"); // error prompt
            return '\0'; // Return null character
        }
        else {
            String chr = input.toUpperCase(); // converts the input to uppercase
            char realChr = chr.charAt(0); // extracts the char from the string
            return realChr; // Return inside the else block
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
    public static void modifyStarWord(char ch, String word,
            StringBuilder starWord) {
        
        // for-loop to iterate through the string and replace all the stars with the character
        for (int i = 0; i < word.length(); i++){

            if (word.charAt(i)==ch){
                starWord.setCharAt(i, ch); // replaces all the stars with the specific character
            }
        }
    }
 
    /*
     * This method takes in a character guess as the parameter and then appends it to an Arraylist which will hold the previous guesses of the user and returns that arraylist.
     * 
     * @param - guess (the guess of the user)
     * @return - arraylist of the guesses done by the user
     */
    public static ArrayList<Character> charGuessed(char guess)
    {

    }

    public static void main(String[] args) {

        boolean okContinue = true;
        ArrayList<Character> charGuessed = new ArrayList<>();

        int noOfGuesses = 1;
        Scanner in = new Scanner(System.in); // creates a scanner object

        System.out.print("Enter a random seed: "); // prompts the user for input for the random seed
        int seed = Integer.parseInt(in.nextLine()); // inputs the seed

        while(okContinue){
            
            System.out.print("Enter a filename for your wordlist: "); 
            String fName = in.nextLine(); // inputs the file name to read from

            List<String> word = readWords(fName); // calls the readWords method and stores the returned list in a variable word.

            String randomWord = getRandomWord(null, word); // calls the getRandomWord method which chooses a random word from the list.
            System.out.println(randomWord);
            boolean isGuessed = true;

            while (isGuessed) {
                
                StringBuilder starredWord = starWord(randomWord); // calls the starWord method which returns a stringbuilder of starred word.
                System.out.println("The word to guess is: " + starredWord); // prints out the starred word.

                System.out.println("Previous character guessed: " + charGuessed); // prints the characters that were previously guessed in the form of an arraylist.

                char guess = getCharacterGuess(in); // calls the getCharacterGuess method to input the user's character guess.

                int count = charCount(guess, randomWord);
                System.out.println("The character " + guess + " occurs in " + count + " positions");

                System.out.println(); // clears the output 

                modifyStarWord(guess, randomWord, starredWord); // calls the modifyStarWord method to change the starred word after the guess.

                System.out.println("The word to guess is: " + starredWord);
                
                System.out.print("Enter your guess for the word: ");
                String guessWord = in.nextLine();

                if (!guessWord.equalsIgnoreCase(randomWord)) {
                    System.out.println("This is not the word.");
                    noOfGuesses++;
                } 
                else {
                    System.out.println("Yes! " + randomWord + " is the correct word!");
                    System.out.println();
                    System.out.println("That took you " + noOfGuesses + " guesses");

                    System.out.print("Would you like a rematch [Y/N]?: ");
                    String doCont = in.nextLine();

                    if (doCont.equals("N")) {
                        System.out.println();
                        System.out.println("Goodbye!");
                        okContinue = false;
                        isGuessed = false;
                    }
                    else if(doCont.equals("Y")){
                        continue;
                    }
                    else{
                        System.out.println("Please enter only a Y or an N.");
                    }
                }
            }
            
        }
        
    }

}
