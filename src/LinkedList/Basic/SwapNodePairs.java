package LinkedList.Basic;

/**
 * Created by Frank on 2016/12/16.
 */
public class SwapNodePairs {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public static ListNode swapPairs(ListNode head) {
        // Write your code here
        // Write your code here
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        ListNode evenDummy = new ListNode(0);
        ListNode oddDummy = new ListNode(0);
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            count++;
        }
        even.next = null;
        odd.next = null;
        count = 1;
        even = evenDummy.next;
        odd = oddDummy.next;
        while (even != null && odd != null) {
            if (count % 2 == 1) {
                newHead.next = even;
                even = even.next;
            } else {
                newHead.next = odd;
                odd = odd.next;
            }
            newHead = newHead.next;
            count++;
        }
        while (even != null) {
            newHead.next = even;
            newHead = newHead.next;
            even = even.next;
        }
        while (odd != null) {
            newHead.next = odd;
            newHead = newHead.next;
            odd = odd.next;
        }
        return dummy.next;
    }
}