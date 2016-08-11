package LinkedList.Advanced;

import java.util.List;

/**
 * Created by Frank on 16/8/4.
 */
public class MergeKSortedLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */

    /**
     * 递归的方法 会导致栈溢出
     * 时间复杂度不好 是O(NK)
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if(lists == null || lists.size() == 0){
            return null;
        }
        if(lists.size() == 1){
            return lists.get(0);
        }
        ListNode left = lists.get(0);
        ListNode right = lists.get(lists.size() - 1);
        lists.remove(lists.size() - 1);
        lists.remove(0);
        ListNode first = merge(left, right);
        lists.add(first);
        mergeKLists(lists);
        return lists.get(0);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
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