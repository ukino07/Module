package algoritm.level4;

import java.util.ArrayList;

/**
 * Created by u_kino07 on 2018. 7. 8..
 */
public class Numrange {
    public int numRange(ArrayList<Integer> A, int B, int C) {
        int count = 0;

        for (int startIndex = 0; startIndex < A.size(); startIndex++) {
            int sum = A.get(startIndex);

            for (int endIndex = startIndex; endIndex < A.size(); endIndex++) {
                if (startIndex < endIndex) {
                    sum += A.get(endIndex);
                }

                if (sum <= C) {
                    if(sum >= B) {
                        System.out.println("sum = " + sum + ", (" + startIndex + ", " + endIndex + ")");
                        count++;
                    }
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
