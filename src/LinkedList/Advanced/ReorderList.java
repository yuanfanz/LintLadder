package LinkedList.Advanced;

/**
 * Created by Frank on 16/8/9.
 */
public class ReorderList {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = findMid(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        merge(head, right);
    }
    private void merge(ListNode left, ListNode right) {
        while (left != null && right != null) {
            ListNode tmp = left.next;
            ListNode tmp2 = right.next;
            left.next = right;
            right.next = tmp;
            left = tmp;
            right = tmp2;
        }
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
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
