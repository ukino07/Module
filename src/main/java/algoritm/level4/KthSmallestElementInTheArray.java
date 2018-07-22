package algoritm.level4;

import java.util.LinkedList;

/**
 * Created by u_kino07 on 2018. 7. 1..
 */
public class KthSmallestElementInTheArray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
//    public int kthsmallest(final List<Integer> unSortedList, int K) {
//        List<Integer> list = new LinkedList<>(unSortedList);
//
//    }

    private void sort(LinkedList<Integer> unSortedList, int startIndex, int endIndex) {
        int pivotIndex = (startIndex + endIndex) / 2;
        int pivot = unSortedList.get(pivotIndex);

        for (int i = startIndex; i <= endIndex; i++) {
            if (unSortedList.get(i) > pivot) {
                if (i > pivotIndex) {
                    continue;
                } else {
                    unSortedList.add(pivotIndex + 1, unSortedList.get(i));
                    unSortedList.remove(i);
                }
            } else {
                if (i > pivotIndex) {
                    unSortedList.add(pivotIndex + 1, unSortedList.get(i));
                    unSortedList.remove(i);
                }
            }
        }

//        for (int number : unSortedList) {
//            if (number > pivot) {
//
//            }
//        }
//        sort(unSortedList, pivot);
    }
}


//        List<Integer> sortedList = unSortedList.stream().sorted().collect(Collectors.toList());
//        return sortedList.get(K-1);


// DO NOT MODIFY THE LIST. IT IS READ ONLY
//    public int kthsmallest(final List<Integer> unSortedList, int K) {
//        List<Integer> sortedList = new LinkedList<>();
//
//        for (Integer number : unSortedList) {
//            if (sortedList.size() == 0) {
//                sortedList.add(0, number);
//                continue;
//            }
//
//            for (int i = sortedList.size() - 1; i >= 0; i--) {
//
//                if (number >= sortedList.get(i)) {
//                    sortedList.add(i + 1, number);
//                    break;
//                } else if (i == 0) {
//                    sortedList.add(i, number);
//                    break;
//                } else {
//                    continue;
//                }
//            }
//        }
//
//        return sortedList.get(K - 1);
//    }
//