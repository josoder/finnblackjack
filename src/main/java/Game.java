/**
 * Created by josoder on 11.04.18.
 */
public class Game {
    // set status to be able to test
    public static int TIE = 0;
    public static int PLAYER_WINS = 1;
    public static int DEALER_WINS = 2;

    private int result = 0;
    private Player dealer;
    private Player player;
    private Deck deck;
    private boolean gameOver = false;
    private int round;

    public Game(Deck deck, String playerName) throws IllegalArgumentException {
        if (deck == null) {
            throw new IllegalArgumentException("deck cant be null");
        }
        if (playerName == null || playerName.isEmpty()) {
            throw new IllegalArgumentException("the player needs a name");
        }

        player = new Player(playerName);
        dealer = new Player("Dealer");
        this.deck = deck;
    }

    public int playGame() {
        dealInitial();

        if (result != 0) {
            return result;
        }

        playerDraw();

        if(result != 0 || !deck.hasCard()) {
            return result;
        }

        dealerDraw();

        if(result != 0) {
            return result;
        }

        result = getFinalResult();

        return result;
    }

    private int getFinalResult() {
        if (player.getScore() == dealer.getScore()) return TIE;
        if (dealer.getScore() > player.getScore()) return DEALER_WINS;

        return PLAYER_WINS;
    }

    private void playerDraw() {
        // if deck is empty set final result and return
        if (!deck.hasCard()){
            result = getFinalResult();
            return;
        }

        if (player.getScore() < 17) {
            player.recieveCard(deck.getCard());
            playerDraw();
        }

        checkForBust();
    }

    private void dealerDraw() {
        // if deck is empty set final result and return
        if (!deck.hasCard()){
            result = getFinalResult();
            return;
        }

        if (dealer.getScore() <= player.getScore()) {
            dealer.recieveCard(deck.getCard());
            dealerDraw();
        }

        checkForBust();
    }

    private void checkForBust() {
        // check for bust
        if (dealer.getScore() > 21) {
            // dealer wins when both players busts
            if (player.getScore() > 21) {
                result = DEALER_WINS;
                return;
            } else {
                result = PLAYER_WINS;
                return;
            }
        }
        if(player.getScore() > 21) result = DEALER_WINS;
    }

    private void dealInitial() {
        player.recieveCard(deck.getCard());
        dealer.recieveCard(deck.getCard());
        player.recieveCard(deck.getCard());
        dealer.recieveCard(deck.getCard());


        // check if either player has Blackjack with their initial hand and wins the game.
        // player wins when both player has Blackjack
        if (this.player.getScore() == 21) {
            result = PLAYER_WINS;
        } else if (this.dealer.getScore() == 21) {
            result = DEALER_WINS;
        }

        checkForBust();
    }

    public void printResult() {
        if(result == PLAYER_WINS) {
            System.out.println(player.getName());
            System.out.println(player);
            System.out.println(dealer);
        }
        else if (result == DEALER_WINS) {
            System.out.println(dealer.getName());
            System.out.println(dealer);
            System.out.println(player);
        }
        else if (result == TIE) {
            System.out.println("TIE");
            System.out.println(dealer);
            System.out.println(player);
        }
    }
}
