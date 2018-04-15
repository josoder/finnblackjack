package se.josoder.blackjack;

import java.util.HashMap;
import java.util.List;

/**
 * Created by josoder on 10.04.18.
 * The valuemapper generates a static HashMap where each card in a deck is mapped to its value.
 * It contains valuable functions for blackjack.
 */
public class ValueMapper {
    private static String[] SUITS = {"C", "D", "S", "H"};

    private static HashMap<String, Integer> valueMap;

    /**
     * Get Hashmap where cards(string represented) is mapped to a value(integer value), for black jack.
     * Example K: HA, V: 11
     * (Ace of hearts = 11)
     * @return
     */
    public static HashMap<String, Integer> GetValueMapper() {
        if (valueMap == null) {
            initMap();
        }

        return valueMap;
    }

    public static int computeHand(List<String> hand) {
        if(hand == null) {
            return 0;
        }
        if(hand.size() == 0) {
            return 0;
        }
        if(valueMap == null) {
            initMap();
        }

        int total = 0;

        for (String c : hand) {
            if(valueMap.containsKey(c)) total += valueMap.get(c);
        }

        return total;
    }

    private static void initMap() {
        valueMap = new HashMap<>();
        for (String s : SUITS) {
            addSuit(s);
        }
    }

    private static void addSuit(String suit) {
        for(int i=2; i<11; i++){

            valueMap.put(suit+ i, i);

            if(i == 10) {

                valueMap.put(suit+ "J", i);
                valueMap.put(suit+ "Q", i);
                valueMap.put(suit+ "K", i);
            }
        }

        valueMap.put(suit + "A", 11);
    }
}
