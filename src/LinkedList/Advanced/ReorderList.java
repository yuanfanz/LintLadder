package LinkedList.Advanced;

/**
 * Created by Frank on 16/8/9.
 */
public class ReorderList {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public ListNode reorderList(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode mid = findMid(head);
        ListNode re = mid.next;
        ListNode newNode = reverse(re);
        mid.next = null;
        return merge(head, newNode);
    }
    private ListNode merge(ListNode head, ListNode newNode){
        ListNode dummy = new ListNode(0);
        ListNode nee = dummy;
        int index = 0;
        while(head != null && newNode != null){
            if(index % 2 == 0){
                nee.next = head;
                head = head.next;
            } else {
                nee.next = newNode;
                newNode = newNode.next;
            }
            nee = nee.next;
            index++;
        }
        if(head != null){
            nee.next = head;
        }
        if(newNode != null){
            nee.next = newNode;
        }
        return dummy.next;
    }
    private ListNode findMid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}
