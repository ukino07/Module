package algoritm.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 6. 17..
 */
public class ReverseBitsTest {
    @Test
    public void test () {
        ReverseBits reverseBits = new ReverseBits();
        assertEquals(0L, reverseBits.reverse(0L));
        assertEquals(3221225472L, reverseBits.reverse(3L));
    }
}