package se.josoder.blackjack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by josoder on 12.04.18.
 */
public class GameTest {
    @Test
    public void testBlackJack() {
        HashSet<String> cards =  new HashSet<>(Arrays.asList("HA", "H10", "CA", "C10"));

        Game game = new Game(new Deck(cards), "Sam");
        Assert.assertTrue(game.playGame() == Game.PLAYER_WINS);
    }

    @Test
    public void badStart() {
        HashSet<String> cards = new HashSet<>(Arrays.asList("HA", "CA", "SA", "DA"));
        Game game = new Game(new Deck(cards), "Sam");

        Assert.assertTrue(game.playGame() == Game.DEALER_WINS);
    }

    @Test
    public void playerShouldStopAtSeventeen() {
        LinkedHashSet<String> cards = new LinkedHashSet<>(Arrays.asList("HA", "C10", "S7", "D7", "C4", "D4"));

        Game game = new Game(new Deck(cards), "Sam");

        Assert.assertTrue(game.playGame() == Game.DEALER_WINS);

        game.printResult();
    }

    @Test
    public void dealerStopsDrawing() {
        LinkedHashSet<String> cards = new LinkedHashSet<>(Arrays.asList("HJ", "SJ", "H5", "S5", "H3", "H4", "H5"));

        Game game = new Game(new Deck(cards), "Sam");
        Assert.assertTrue(game.playGame() == Game.DEALER_WINS);
    }

    @Test
    public void outOfCards() {
        LinkedHashSet<String> cards = new LinkedHashSet<>(Arrays.asList("H2", "H4", "H6", "H7"));

        Game game = new Game(new Deck(cards), "Sam");
        Assert.assertTrue(game.playGame() == Game.DEALER_WINS);
    }
}
