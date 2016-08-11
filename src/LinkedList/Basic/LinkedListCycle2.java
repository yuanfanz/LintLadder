package LinkedList.Basic;

/**
 * Created by Frank on 16/8/4.
 */
public class LinkedListCycle2 {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        while(head != slow.next){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}