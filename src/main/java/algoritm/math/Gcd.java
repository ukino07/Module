package algoritm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 4. 22..
 */
public class Gcd {
    public int gcd(int A, int B) {
        if (A == B) {
            return A;
        }

        if (Math.max(A, B) % Math.min(A, B) == 0) {
            return Math.min(A, B);
        }

        if (isPrime(A) || isPrime(B)) {
            return 1;
        }

        List<Integer> primes = getPrimes(Math.max(A, B));

        for (int i = primes.size()-1; i >= 0; i--) {
            if ((A % primes.get(i) == 0) && (B % primes.get(i) == 0)) {
                return primes.get(i);
            }
        }

        return 1;
    }

    private List<Integer> getPrimes(int maxLimit) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 1; i <= maxLimit; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) { // 서로소 아님
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }

        }

        return primes;
    }

    private boolean isPrime(int number) {
        for (int i = 1; i < number; i++) {
            if (number % i == 0) { // 서로소 아님
                return false;
            }
        }

        return true;
    }
}
