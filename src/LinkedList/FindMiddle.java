package LinkedList;

/**
 * Created by Frank on 16/7/26.
 */
public class FindMiddle {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // Write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode sin = head;
        ListNode dou = head.next;
        while(dou != null && dou.next != null){
            sin = sin.next;
            dou = dou.next.next;
        }
        return sin;
    }
}
