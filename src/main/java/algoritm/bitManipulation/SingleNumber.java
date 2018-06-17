package algoritm.bitManipulation;

import java.util.List;

/**
 * Created by u_kino07 on 2018. 6. 17..
 */
public class SingleNumber {
    public int singleNumber(final List<Integer> numbers) {
        int singleNumber = 0;

        for (int number : numbers) {
            singleNumber ^= number;
        }

        return singleNumber;
    }

//    int i = 0;
//    while(numbers.size() > 1) {
//        int number = numbers.remove(i++);
//
//        if (numbers.contains(number)) {
//            numbers.remove(numbers.indexOf(number));
//        } else {
//            return number;
//        }
//    }
//
//    return numbers.get(1);
}
