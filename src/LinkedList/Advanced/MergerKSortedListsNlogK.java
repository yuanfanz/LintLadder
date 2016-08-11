package LinkedList.Advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 16/8/4.
 */
public class MergerKSortedListsNlogK {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    /**
     * 有二分法的思想
     * divide and conquer
     * 递归的方法
     * 时间复杂度 O(Nlogk)
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if(lists == null || lists.size() == 0){
            return null;
        }
        return helper(lists, 0, lists.size() - 1);
    }
    private ListNode helper(List<ListNode> lists, int start, int end){
        if(start == end){
            return lists.get(start);
        }
        int mid = start + (end - start)/2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return merge(left, right);
    }

    /**
     * 两两合并的方法
     * 不是递归
     * 时间复杂度 O(Nlogk)
     */
    public ListNode twoCombine(List<ListNode> lists) {
        // write your code here
        if(lists == null || lists.size() == 0){
            return null;
        }
        while(lists.size() > 1){
            List<ListNode> newList = new ArrayList<ListNode>();
            for(int i = 0; i + 1 < lists.size(); i += 2){
                ListNode newnode= merge(lists.get(i), lists.get(i + 1));
                newList.add(newnode);
            }
            if(lists.size() % 2 == 1){
                newList.add(lists.get(lists.size() - 1));
            }
            lists = newList;
        }
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
