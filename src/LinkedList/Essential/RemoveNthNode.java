package LinkedList.Essential;

/**
 * Created by Frank on 16/8/3.
 */
public class RemoveNthNode {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode first = head;
        ListNode last = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for(int i = 0; i <= n; ++i){
            if(last == null){
                if(i == n){
                    dummy.next = dummy.next.next;
                }
                return dummy.next;
            }
            last = last.next;
        }
        while(last != null){
            first = first.next;
            last = last.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}