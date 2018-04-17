package algoritm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 4. 15..
 */
public class MaxSumContiguousSubarray {

    public int maxSubArray(final List<Integer> list) {
        List<Integer> cases = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                cases.add(getSum(list, i, j));
            }
        }

        return getMax(cases);
    }

    private int getSum(List<Integer> list, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += list.get(i);
        }
        return sum;
    }

    private int getMax(List<Integer> cases) {
        int max = cases.get(0);
        for (int i = 1; i < cases.size(); i++) {
            if (cases.get(i) > max) {
                max = cases.get(i);
            }
        }
        return max;
    }
}
