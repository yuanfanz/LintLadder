package LinkedList.Essential;

/**
 * Created by Frank on 16/8/3.
 */
public class RemoveNthNode {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = head;
        head = dummy;
        while (n != 0) {
            if (tmp == null) {
                return dummy.next;
            }
            tmp = tmp.next;
            n--;
        }
        while (tmp != null) {
            head = head.next;
            tmp = tmp.next;
        }
        head.next = head.next.next;
        return dummy.next;
    }
}