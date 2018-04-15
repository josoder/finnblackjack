package se.josoder.blackjack;

import org.junit.Assert;
import org.junit.Test;
import java.util.Set;

/**
 * Created by josoder on 13.04.18.
 */
public class ParserTest {

    @Test
    public void parseFileTest(){
        Parser parser = new Parser("cards.txt");
        Set<String> content = null;

        try {
            content = parser.getContent();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Assert.assertTrue(content != null);
        Assert.assertTrue(content.size() == 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseFileFail(){
        Parser parser = new Parser("");
    }
}
