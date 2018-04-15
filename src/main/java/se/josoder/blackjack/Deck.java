package se.josoder.blackjack;

import java.util.*;

/**
 * Created by josoder on 10.04.18.
 */
public class Deck {
    private Stack<String> deck;

    /**
     * Initialize a shuffled complete deck with 52 card.
     */
    public Deck(){
        deck = new Stack<>();
        // The keys in the valueMap is a complete deck of cards
        ArrayList<String> keys = new ArrayList<>(ValueMapper.GetValueMapper().keySet());

        // Shuffle the cards
        Collections.shuffle(keys);

        //System.out.println(keys);

        keys.forEach((c) -> deck.push(c));
    }

    /**
     * Create a deck in the form of a set of strings.
     * The string representation of the card should be in the following format : H1, HJ, HK, HA, C1, C10 etc..
     * @param cards
     */
    public Deck(Set<String> cards) throws IllegalArgumentException {
        if (cards == null) throw new IllegalArgumentException("cards cant be null");

        if(cards.size() < 4) throw new IllegalArgumentException("the deck needs at least 4 cards");

        deck = new Stack<>();
        for (String card : cards) {
            validateAndAddCard(card);
        }

        // to maintain order as described in the assignment
        Collections.reverse(deck);


        if (deck.size() < 4) {
            throw new IllegalArgumentException("Needs at least 4 valid cards");
        } else {
            System.out.println("successfully added " + deck.size() + " cards to the deck");
        }
    }

    public boolean hasCard() {
        return deck.size() > 0;
    }

    public String getCard() {
        if(hasCard()) return deck.pop();
        else {
            return null;
        }
    }

    public Stack<String> getDeck() {
        return deck;
    }


    private void validateAndAddCard(String card) {
        if(ValueMapper.GetValueMapper().containsKey(card)){
            deck.push(card);
        } else {
            System.out.println(card + " is not a valid card");
        }
    }
}
