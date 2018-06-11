package algoritm.binarySearch;

import java.util.ArrayList;

/**
 * Created by u_kino07 on 2018. 5. 20..
 */
public class SortedInsertPosition {

    public int searchInsert(ArrayList<Integer> list, int target) {
        return searchInsert(list, target, 0, list.size() - 1);
//        return searchInsert(list, target, 0, list.size());
    }

    public int searchInsert(ArrayList<Integer> list, int target, int startIndex, int endIndex) {   //0, 1, 2
        int middleIndex = (startIndex + endIndex) / 2;

        if (target == list.get(middleIndex)) {
            return middleIndex;
        }

        if (endIndex - startIndex <= 1) {
            if (target > list.get(startIndex) && target < list.get(endIndex)) {
                return endIndex;
            }

            if (target < list.get(startIndex)) {
                return startIndex;
            }

            if (target >  list.get(endIndex)) {
                return endIndex + 1;
            }
        }

        if (target < list.get(middleIndex)) {
            return searchInsert(list, target, startIndex, middleIndex - 1);
        }

        return searchInsert(list, target, middleIndex + 1, endIndex);



//        if (startIndex == endIndex) {
//            return startIndex;
//        }
//
//        int middleIndex = (startIndex + endIndex) / 2;
//        Integer middleNum = numbers.get(middleIndex);
//
//        if (target <= middleNum) {
//            return searchInsert(numbers, target, startIndex, middleIndex);
//        } else {
//            return searchInsert(numbers, target, middleIndex + 1, endIndex);
//        }
    }


}
