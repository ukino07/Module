package algoritm.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 7. 22..
 */
public class ReverseLinkedListTest {
    @Test
    public void test() {
        // ready
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);

        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);

        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(8);

        a1.next = a2;  // a2.next = a1;
        a2.next = b1;  // b1.next = a2;
        b1.next = b2;  // b2.next = b1;
        b2.next = b3;  // b3.next = b2;
        b3.next = c1;  // c1.next = b3;
        c1.next = c2;  // c2.next = c1;
        c2.next = c3;  // c3.next = c2;









        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        assertEquals(reverseLinkedList.reverseList(a1), c3);

    }

}
