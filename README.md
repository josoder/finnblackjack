# finnblackjack

## Can you beat the dealer at 21?

How to run: <br>
<code>mvn package</code> run tests and create jar
<br>
<code>mvn test</code> run tests
<br>
<code>java -jar target/blackjack-1.0-SNAPSHOT.jar</code> to run the application
<br>
 
The game is able to read a file containing a deck of cards, taking the
reference to the file as a command line argument, as a starting point. If no file is
provided, a new shuffled deck of 52 unique cards will be initialized.
The list has to be in the following format:
CA, D4, H7, SJ,..., S5, S9, D10

The file needs to contain at least 4 cards otherwise a deck will be generated.

<code>java -jar target/blackjack-1.0-SNAPSHOT.jar cards.txt</code> will parse the example file in the root folder and 
generate a round with a deck derived from it. 

<br>

[Assignment text](assignment.pdf)


