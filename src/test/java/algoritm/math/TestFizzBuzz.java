package algoritm.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 4. 22..
 */
public class TestFizzBuzz {
    @Test
    public void 테스트() {
        int n = 5;
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> result = fizzBuzz.getResult(n);
        System.out.println(result);

        assertEquals(
                new ArrayList<>(Arrays.asList("1", "2", "Fizz", "4", "Buzz")),
                fizzBuzz.getResult(5)
        );
    }
}
