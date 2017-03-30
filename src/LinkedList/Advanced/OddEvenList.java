package LinkedList.Advanced;

/**
 * Created by yuanfanz on 17/3/28.
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        int count = 1;
        ListNode dummyL = new ListNode(0);
        ListNode dummyR = new ListNode(0);
        ListNode left = dummyL;
        ListNode right = dummyR;
        while (head != null) {
            if (count % 2 == 0) {
                right.next = head;
                right = right.next;
            } else {
                left.next = head;
                left = left.next;
            }
            head = head.next;
            count++;
        }
        left.next = dummyR.next;
        right.next = null;
        return dummyL.next;
    }
}