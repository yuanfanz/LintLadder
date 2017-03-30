package LinkedList.Advanced;

/**
 * Created by yuanfanz on 17/3/28.
 */
public class PlusOne {
    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int carry = 1;
        while (head != null) {
            int sum = head.val + carry;
            head.val = sum % 10;
            carry = sum / 10;
            head = head.next;
        }
        head = dummy;
        while (head.next != null) {
            head = head.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(1);
            head.next = node;
        }
        return reverse(dummy.next);
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
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