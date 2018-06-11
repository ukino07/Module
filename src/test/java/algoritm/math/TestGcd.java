package algoritm.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 4. 22..
 */
public class TestGcd {
    @Test
    public void 테스트() {
        Gcd gcd = new Gcd();
        assertEquals(gcd.gcd(2, 4), 2);
    }
}
