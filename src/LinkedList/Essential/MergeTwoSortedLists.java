package LinkedList.Essential;

/**
 * Created by Frank on 16/8/4.
 */
public class MergeTwoSortedLists {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode i = l1;
        ListNode j = l2;
        ListNode newHead = new ListNode(0);
        ListNode dummy = newHead;
        while(i != null && j != null){
            if(i.val < j.val){
                dummy.next = i;
                dummy = i;
                i = i.next;
            } else {
                dummy.next = j;
                dummy = j;
                j = j.next;
            }
        }
        while(i != null){
            dummy.next = i;
            dummy = i;
            i = i.next;
        }
        while(j != null){
            dummy.next = j;
            dummy = j;
            j = j.next;
        }
        return newHead.next;
    }
}