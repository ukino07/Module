package algoritm.inplaceUpdate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 6. 26..
 */
public class SortByColorTest {
    @Test
    public void test() {
        SortByColor sortByColor = new SortByColor();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
//        a.add(1);
//        a.add(2);
//        a.add(0);
//        a.add(1);
//        a.add(2);
        List<Integer> expected = Arrays.asList(0);// , 0, 1, 1, 2, 2);
        sortByColor.sortColors(a);

        assertEquals(a, expected);
    }
}