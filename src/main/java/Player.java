import java.util.ArrayList;
import java.util.List;

/**
 * Created by josoder on 11.04.18.
 */
public class Player {
    private List<String> hand;
    private String name;


    public Player(String name){
        this.name = name;
        hand = new ArrayList<>();
    }

    public void recieveCard(String card){
         hand.add(card);
    }

    public int getScore() {
        return ValueMapper.computeHand(this.hand);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(name + ":" +  " ");

        for (int i=0; i<hand.size(); i++) {
            ret.append(hand.get(i));
            if(i<hand.size()-1) ret.append(", ");
        }

        return ret.toString();
    }
}
