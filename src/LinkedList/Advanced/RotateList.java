package LinkedList.Advanced;

/**
 * Created by Frank on 16/8/9.
 */
public class RotateList {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = head;
        while(dummy.next != null){
            dummy = dummy.next;
        }
        dummy.next = head;

        ListNode slow = head;
        ListNode fast = head;
        while(k > 0 && fast != null){
            fast = fast.next;
            k--;
        }
        dummy.next = null;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        ListNode tmp = slow.next;
        slow.next = null;
        return tmp;
    }
}