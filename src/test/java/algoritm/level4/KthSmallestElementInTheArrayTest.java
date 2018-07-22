package algoritm.level4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 7. 1..
 */
public class KthSmallestElementInTheArrayTest {
    @Test
    public void test() {
        List<Integer> unSortedList = Arrays.asList(2, 1, 4, 3, 2);
        int K = 3;
        KthSmallestElementInTheArray kthSmallestElementInTheArray = new KthSmallestElementInTheArray();
//        assertEquals(2, kthSmallestElementInTheArray.kthsmallest(unSortedList, K));
    }

//    @Test
//    public void test1() {
//        List<Integer> unSortedList = Arrays.asList(2, 1, 4, 3, 2);
//        LinkedList<Integer> linkedList = new LinkedList<>(unSortedList);
//        linkedList.add(1, 7);
//        System.out.println(linkedList);
//    }
}