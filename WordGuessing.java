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
            while((word = reader.readLine()) != null){ 
                if(!word.isEmpty()){
                    words.add(word.toUpperCase()); // appends the word to the list.
                }
            }
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

        return randomWord;
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
        // TODO - complete this function

        // TODO - the following line is only here to allow this program to
        //  compile.  Replace it and remove this comment when you complete
        //  this method.
        return null;
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
        // TODO - complete this function

        // TODO - the following line is only here to allow this program to
        //  compile.  Replace it and remove this comment when you complete
        //  this method.
        return 0;
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
        // TODO - complete this function

        // TODO - the following line is only here to allow this program to
        //  compile.  Replace it and remove this comment when you complete
        //  this method.
        return 0;
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
        // TODO - complete this function

    }

    public static void main(String[] args) {
        
        System.out.println(readWords("words.txt"));

    }

}
