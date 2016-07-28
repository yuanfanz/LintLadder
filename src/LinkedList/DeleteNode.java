package LinkedList;

/**
 * Created by Frank on 16/7/26.
 */
public class DeleteNode {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    /**
     * @param head is the head of the linked list
     * @return: ListNode head of linked list
     */

    /**
     * 排序链表删除重复的元素
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
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
}
