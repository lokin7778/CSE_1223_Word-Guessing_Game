# CSE_1223_Word-Guessing_Game

1. One problem i faced was while adding the words into the arraylist. What I did was I called reader.readline() twice in the code which skips every other line in the file. 
Soln. String word;
while((word = reader.readLine()) != null)

2. Another problem I faced was the nullpointerexception, the code will crash in the end if we use .isEmpty(). So we need to use the null. 

3. Another problem I faced was in the getCharacterGuess method, where I returned the char outside the else block causing an error in the code.
Soln. I returned a null value in the if block to handle the error, and then finally returned the original return character in the else block.

4. ONE More problem I am facing is that I am not able to append the guessed characters to the arraylist and show what are the guessed characters. 
Soln. I am creating a new method which takes in a guess paramater and appends it to the arraylist and returns the arraylist.