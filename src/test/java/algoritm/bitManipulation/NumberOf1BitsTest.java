package algoritm.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 6. 17..
 */
public class NumberOf1BitsTest {
    @Test
    public void test() {
        NumberOf1Bits bits = new NumberOf1Bits();
        assertEquals(3, bits.numSetBits(11));
    }
}