package algoritm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 4. 22..
 */
public class FizzBuzz {

    public List<String> getResult(int number) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            String item = Integer.toString(i);

            if (i % 3 == 0 && i % 5 == 0) {
                item = "FizzBuzz";
            }

            if (i % 3 == 0) {
                item = "Fizz";
            }
            if (i % 5 == 0) {
                item = "Buzz";
            }
            result.add(item);
        }

        return result;
    }

}
