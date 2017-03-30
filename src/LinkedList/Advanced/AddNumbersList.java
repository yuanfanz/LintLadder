package LinkedList.Advanced;

/**
 * Created by Frank on 16/8/9.
 */
public class AddNumbersList {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null && l2 == null){
            return null;
        }
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode nee = dummy;
        while(l1 != null && l2 != null){
            int tmp = l1.val + l2.val + carry;
            nee.next = new ListNode(tmp % 10);
            carry = tmp / 10;
            l1 = l1.next;
            l2 = l2.next;
            nee = nee.next;
        }
        while(l1 != null){
            int tmp = l1.val + carry;
            nee.next = new ListNode(tmp % 10);
            carry = tmp / 10;
            l1 = l1.next;
            nee = nee.next;
        }
        while(l2 != null){
            int tmp = l2.val + carry;
            nee.next = new ListNode(tmp % 10);
            carry = tmp / 10;
            l2 = l2.next;
            nee = nee.next;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            nee.next = newNode;
        }
        return dummy.next;
    }
}