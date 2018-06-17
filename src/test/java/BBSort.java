import org.junit.Test;

/**
 * Created by u_kino07 on 2018. 6. 13..
 */
public class BBSort {
    @Test
    public void test() {
        int[] arr = {5, 2, 1};
        sort(arr);
    }

    public static void sort(int[] ns) {
        int a = 0, tmp = 0;

        while (a < ns.length) {
            for (int j = 0; j < ns.length - 1 - a; j++) {
                if (ns[j] > ns[j + 1]) {
                    tmp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = tmp;
                }
            }
            a++;
        }

        for (int i = 0; i < ns.length; i++) {
            System.out.println(ns[i] + " ");
        }
    }
}
