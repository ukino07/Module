package algoritm.bitManipulation;

/**
 * Created by u_kino07 on 2018. 6. 17..
 */
public class ReverseBits {
    public long reverse(long number) {
        long reverseNumber = 0;

        for (int i = 0; i < 32; i++) {
            if (i != 0) {
                reverseNumber <<= 1;
            }

            reverseNumber += number % 2;
            number >>= 1;
        }

        return reverseNumber;
    }
}
