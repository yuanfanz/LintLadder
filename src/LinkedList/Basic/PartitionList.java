package LinkedList.Basic;

/**
 * Created by Frank on 16/8/4.
 */
public class PartitionList {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode leftdummy = new ListNode(0);
        ListNode rightdummy = new ListNode(0);
        ListNode left = leftdummy;
        ListNode right = rightdummy;
        while(head != null){
            if(head.val < x){
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightdummy.next;
        return leftdummy.next;
    }
}

