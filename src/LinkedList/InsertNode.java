package LinkedList;

/**
 * Created by Frank on 16/7/26.
 */
public class InsertNode {
    /**
     * @param head: The head of linked list.
     * @param val: an integer
     * @return: The head of new linked list
     */
    public ListNode insertNode(ListNode head, int val) {
        // Write your code here
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        head = dummy;
        ListNode newNode = new ListNode(val);
        if(head == null){
            newNode.next = null;
            return newNode;
        }
        while(head != null){
            if(head.val == val){
                ListNode tmp = head.next;
                head.next = newNode;
                newNode.next = tmp;
                return dummy.next;
            } else if (head.val < val){
                if (head.next == null) {
                    head.next = newNode;
                    newNode.next = null;
                    return dummy.next;
                } else if (head.next.val > val){
                    ListNode tmp = head.next;
                    head.next = newNode;
                    newNode.next = tmp;
                    return dummy.next;
                } else {
                    head = head.next;
                }
            }
        }
        return dummy.next;
    }
}
