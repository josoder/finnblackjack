import javax.sound.midi.Soundbank;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;

/**
 * Created by josoder on 10.04.18.
 */
public class Main {
    private static Game game;
    private static Parser parser;
    private static Deck deck;


    public static void main(String[] args){
        if(args.length > 0) {
            try {
                parser = new Parser(args[0]);
                LinkedHashSet<String> cards = parser.getContent();

                if(cards != null) {
                    deck = new Deck(cards);
                    game = new Game(deck, "Sam");
                }

            } catch (Exception e){
                System.out.println("generating deck.. \n \n");
            }
        }

        if (deck == null ) game = new Game(new Deck(), "Sam");

        game.playGame();

        game.printResult();
    }
}
