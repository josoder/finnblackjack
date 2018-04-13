import org.junit.Assert;
import org.junit.Test;

/**
 * Created by josoder on 11.04.18.
 */
public class PlayerTest {
    @Test
    public void PlayerTest() {
        Player sam = new Player("sam");

        sam.recieveCard("H3");
        sam.recieveCard("H4");

        Assert.assertTrue(sam.getScore() == 7);
        Assert.assertTrue(sam.toString().equals("sam: H3, H4"));
    }
}
