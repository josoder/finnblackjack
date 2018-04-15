package se.josoder.blackjack;

import java.util.LinkedHashSet;

/**
 * Created by josoder on 10.04.18.
 */
public class Main {
    private static Game game;
    private static se.josoder.blackjack.Parser parser;
    private static Deck deck;


    public static void main(String[] args){
        // Check for args
        if(args.length > 0) {
            // If the file does'nt exist or is invalid, an exception will be thrown.
            try {
                parser = new Parser(args[0]);
                LinkedHashSet<String> cards = parser.getContent();

                if(cards != null) {
                    deck = new Deck(cards);
                    game = new Game(deck, "Sam");
                }

            } catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("generating deck.. \n \n");
            }
        }
        // If no argument was passed or the file referenced to was invalid, generate a new deck and shuffle it.
        if (deck == null ) game = new Game(new Deck(), "Sam");

        game.playGame();

        game.printResult();
    }
}
