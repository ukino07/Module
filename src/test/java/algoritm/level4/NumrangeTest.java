package algoritm.level4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 7. 8..
 */
public class NumrangeTest {
    @Test
    public void test() {
        Numrange numrange = new Numrange();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1));
        int B = 1;
        int C = 3;
        assertEquals(numrange.numRange(A, B, C), 15);
    }

    @Test
    public void test2() {
        Numrange numrange = new Numrange();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10, 5, 1, 0, 2));
        int B = 6;
        int C = 8;
        assertEquals(numrange.numRange(A, B, C), 3);
    }
}