package algoritm.twoPointers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 6. 26..
 */
public class IntersectionOfSortedArraysTest {
    @Test
    public void test1() {
        List<Integer> A = Arrays.asList(1, 2, 3, 3, 4, 5, 6);
        List<Integer> B = Arrays.asList(3, 3, 5);
        List<Integer> expected = Arrays.asList(3, 3, 5);

        IntersectionOfSortedArrays intersectionOfSortedArrays = new IntersectionOfSortedArrays();
        assertEquals(intersectionOfSortedArrays.intersect(A, B), expected);
    }

    @Test
    public void test2() {
        List<Integer> A = Arrays.asList(1, 2, 3, 3, 4, 5, 6);
        List<Integer> B = Arrays.asList(3, 5);
        List<Integer> expected = Arrays.asList(3, 5);

        IntersectionOfSortedArrays intersectionOfSortedArrays = new IntersectionOfSortedArrays();
        assertEquals(intersectionOfSortedArrays.intersect(A, B), expected);
    }

    @Test
    public void test3() {
        List<Integer> A = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> B = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> expected = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0);

        IntersectionOfSortedArrays intersectionOfSortedArrays = new IntersectionOfSortedArrays();
        assertEquals(intersectionOfSortedArrays.intersect(A, B), expected);
    }

}