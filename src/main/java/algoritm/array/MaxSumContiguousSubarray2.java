package algoritm.array;

import java.util.List;

/**
 * Created by u_kino07 on 2018. 4. 15..
 */
public class MaxSumContiguousSubarray2 {

    public int maxSubArray(final List<Integer> list) {
        int max = list.get(0);
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            if (sum >= 0) {
                sum += list.get(i);
            } else {
                sum = list.get(i);
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
