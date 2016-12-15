package LinkedList.Essential;

/**
 * Created by Frank on 16/8/3.
 */
public class RemoveNodeByValue {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public static ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
    public ListNode removeElements2(ListNode head, int val) {
        // Another solution for this problem
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            }
            head = head.next;
        }
        return dummy.next;
    }
}