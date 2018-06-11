package algoritm.math;

/**
 * Created by u_kino07 on 2018. 4. 22..
 */
public class Gcd2 {
    public int gcd(int A, int B) {
        int max = Math.max(A, B);
        int min = Math.min(A, B);

        if (max % min == 0) {
            return min;
        } else {
            return gcd(min, max % min);
        }
    }
}
