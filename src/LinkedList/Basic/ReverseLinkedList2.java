package LinkedList.Basic;

/**
 * Created by Frank on 16/8/9.
 */
public class ReverseLinkedList2 {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if(head == null){
            return null;
        }
        //find prevM
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode nee = dummy;
        while(m > 1){
            nee = nee.next;
            m--;
        }
        ListNode prevM = nee;
        ListNode mNode = nee.next;
        nee = dummy;
        while(n > 0){
            nee = nee.next;
            n--;
        }
        ListNode nNode = nee;
        ListNode postN = nee.next;
        reverse(prevM, mNode, postN);
        prevM.next = nNode;
        mNode.next = postN;
        return dummy.next;
    }
    private ListNode reverse(ListNode prevM, ListNode m, ListNode postN){

        while(m != postN){
            ListNode tmp = m.next;
            m.next = prevM;
            prevM = m;
            m = tmp;
        }
        return prevM;
    }
}
