package LinkedList.Essential;

/**
 * Created by Frank on 16/8/3.
 */
public class RemoveDuplicates {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next.next != null){
            if(head.next.val == head.next.next.val){
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}