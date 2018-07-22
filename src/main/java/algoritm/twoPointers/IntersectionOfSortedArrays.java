package algoritm.twoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 6. 26..
 */
public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> intersect = new ArrayList<>();
        int aPointer = 0;
        int bPointer = 0;

        while (aPointer < A.size() && bPointer < B.size()) {
            if (A.get(aPointer).equals(B.get(bPointer))) {
                intersect.add(A.get(aPointer));
                aPointer++;
                bPointer++;
            } else if (A.get(aPointer) < B.get(bPointer)) {
                aPointer++;
            } else {
                bPointer++;
            }
        }
        return intersect;
    }







//    // DO NOT MODIFY THE LIST. IT IS READ ONLY
//    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
//        ArrayList<Integer> temp = new ArrayList<>(A) ;
//        ArrayList<Integer> intersect = new ArrayList<>() ;
//
//        for (Integer value : B) {
//            if (temp.remove(value)) {
//                intersect.add(value);
//            }
//        }
//
//        return intersect;
//    }


}
