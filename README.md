# CSE_1223_Word-Guessing_Game

1. One problem i faced was while adding the words into the arraylist. What I did was I called reader.readline() twice in the code which skips every other line in the file. 
Soln. String word;
while((word = reader.readLine()) != null)

2. Another problem I faced was the nullpointerexception, the code will crash in the end if we use .isEmpty(). So we need to use the null. 