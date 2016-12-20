package LinkedList.Basic;

/**
 * Created by Frank on 16/8/9.
 */
public class ReverseLinkedList2 {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public static ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (head == null || head.next == null || m >= n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (m != 1) {
            head = head.next;
            m--;
        }
        ListNode prevM = head;
        ListNode mNode = head.next;
        head = dummy;
        while (n != 0) {
            head = head.next;
            n--;
        }
        ListNode nNode = head;
        ListNode postN = head.next;
        nNode = reverse(mNode, postN);
        prevM.next = nNode;
        mNode.next = postN;
        return dummy.next;
    }
    private static ListNode reverse(ListNode head, ListNode last) {
        ListNode prev = null;
        while (head != last) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}
