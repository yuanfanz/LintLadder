package LinkedList.Advanced;

/**
 * Created by Frank on 2016/11/13.
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }
        head = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int carry = 1;
        while (head != null && carry > 0) {
            int sum = head.val + carry;
            carry = sum / 10;
            head.val = sum % 10;
            head = head.next;
        }
        head = dummy.next;
        while (head.next != null) {
            head = head.next;
        }
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            head.next = newNode;
        }
        head = dummy.next;
        return reverse(head);
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}