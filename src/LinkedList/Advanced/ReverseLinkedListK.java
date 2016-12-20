package LinkedList.Advanced;

import LinkedList.Basic.ReverseLinkedList2;
import LinkedList.Basic.ListNode;

/**
 * Created by Frank on 2016/12/18.
 */
public class ReverseLinkedListK {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if (head == null || head.next == null) return head;
        int m = 1;
        int n = k;
        int len = lengthCheck(head);
        int turn = len / k;
        while (turn != 0) {
            head = ReverseLinkedList2.reverseBetween(head, m, n);
            m += k;
            n += k;
            turn--;
        }
        return head;
    }
    private int lengthCheck(ListNode head) {
        int result = 0;
        while (head != null) {
            head = head.next;
            result++;
        }
        return result;
    }
}