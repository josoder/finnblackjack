package se.josoder.blackjack;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by josoder on 10.04.18.
 */
public class ValueMapperTest {
    public HashMap<String, Integer> valueMap;

    @Test
    public void testInitsValues() {
        valueMap = ValueMapper.GetValueMapper();
        Assert.assertEquals(52, valueMap.size());
    }

    @Test
    public void testCheckValues() {
        valueMap = ValueMapper.GetValueMapper();
        Assert.assertTrue(valueMap.get("SA") == 11);
        Assert.assertTrue(valueMap.get("H4") == 4);
    }
}
