package algoritm;

import java.util.ArrayList;

/**
 * Created by u_kino07 on 2018. 5. 13..
 */
public class PrettyPrint {
//    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        int maxLimit = A + 2;
//
//        List<Border> borders = new ArrayList<>();
//        for (int i = A; i > 0; i--) {
//
//        }
//
//
//        for (int row = 0; row <= maxLimit; row++) {
//            if (row == ) {
//
//            }
//
//            for (int height = 0; height <= maxLimit; height++) {
//
//                int upper = A + 2;
//                int lower = maxLimit - upper;
//
//
//            }
//        }
//
//        class Border {
//            private int value;
//            private Bound bound;
//
//            Border (int value) {
//                this.value = value;
//                this.bound = new Bound(maxLimit - (value + 2), value + 2);
//            }
//
//            class Bound {
//                private int lower;
//                private int upper;
//
//                Bound (int lower, int upper) {
//                    this.lower = lower;
//                    this.upper = upper;
//                }
//            }
//        }
//    }

    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 0; i < A * 2 + 1; i++) {
            if (i == A || i == A + 1) {
                continue;
            }
            values.add(Math.abs(A - i));
        }

        for (int i = 0; i < A * 2 - 1; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < A * 2 - 1; j++) {
                row.add(Math.max(values.get(i), values.get(j)));
            }

            result.add(row);
        }

        return result;
    }

}
