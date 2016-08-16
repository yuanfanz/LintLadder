package LinkedList.Advanced;

/**
 * Created by Frank on 16/8/8.
 */
public class SortListMergeSort {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode right = mergeSort(mid.next);
        mid.next = null;
        ListNode left = mergeSort(head);
        return merge(left, right);
    }
    private ListNode findMid(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                head.next = l1;
                head = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = l2;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            head.next = l1;
            head = l1;
            l1 = l1.next;
        }
        while(l2 != null){
            head.next = l2;
            head = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }
}