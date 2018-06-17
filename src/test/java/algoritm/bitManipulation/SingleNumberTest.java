package algoritm.bitManipulation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 6. 17..
 */
public class SingleNumberTest {
    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 4, 1);
        SingleNumber singleNumber = new SingleNumber();
        System.out.print(singleNumber.singleNumber(numbers));

//        assertEquals(singleNumber.singleNumber(numbers), 4);
    }

}