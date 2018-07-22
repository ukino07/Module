package algoritm.linkedList;

/**
 * Created by u_kino07 on 2018. 7. 22..
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode listNode) {
        ListNode previousNode;
        ListNode nextNode = listNode;
        ListNode tempNode = listNode.next;

        while(tempNode != null) {
            previousNode = nextNode;
            nextNode = tempNode;
            tempNode = tempNode.next;
            nextNode.next = previousNode;
        }

        listNode.next = null;
        return nextNode;
    }
}