package algoritm.linkedList;

/**
 * Created by u_kino07 on 2018. 7. 21..
 */
public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        int diffSize = getListNodeSize(a) - getListNodeSize(b);
        ListNode longListNode = a;
        ListNode shortListNode = b;

        if (diffSize < 0) {
            longListNode = b;
            shortListNode = a;
            diffSize *= -1;
        }

        for (int i = 0; i < diffSize; i++) {
            longListNode = longListNode.next;
        }

        while (true) {
            if (longListNode == null || shortListNode == null) {
                break;
            }

            if (longListNode == shortListNode) {
                return longListNode;
            } else {
                longListNode = longListNode.next;
                shortListNode = shortListNode.next;
            }
        }

        return null;
    }

    public int getListNodeSize(ListNode listNode) {
        int size = 0;

        while(true) {
            if (listNode == null) {
                break;
            }
            size++;
            listNode = listNode.next;
        }

        return size;
    }

//    public ListNode getIntersectionNode0(ListNode a, ListNode b) {
//        ListNode one = a;
//        while (true) {
//            if (one == null) {
//                break;
//            }
//
//            ListNode theOther = b;
//            while(true) {
//                if (theOther == null) {
//                    break;
//                }
//
//                if (one == theOther) {
//                    return one;
//                } else {
//                    theOther = theOther.next;
//                }
//            }
//            one = one.next;
//        }
//
//        return null;
//    }
}