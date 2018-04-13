import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by josoder on 11.04.18.
 */
public class DeckTest {

    @Test
    public void testInitDeckWithoutParam() {
        Deck deck = new Deck();

        Assert.assertTrue(deck.getDeck().size() == 52);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitWithNullParam() {
        Deck deck = new Deck(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitWithEmptyList() {
        Deck deck = new Deck(new HashSet<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void needsAtleastFourValidCards() {
        Deck deck = new Deck(new HashSet<>(Arrays.asList("H2","H3", "H4", "44")));
    }

    @Test
    public void testInitWithParam () {
        HashSet<String> cardSet = new HashSet<>(Arrays.asList("H4", "H3", "C2", "HK", "S7", "ZZ", "H1"));

        Deck deck = new Deck(cardSet);

        // only the valid cards should be in the deck
        Assert.assertTrue(deck.getDeck().size() == 5);

        for (int i=0; i<5; i++){
            System.out.println(deck.getCard());
        }

        Assert.assertFalse(deck.hasCard());
    }
}
