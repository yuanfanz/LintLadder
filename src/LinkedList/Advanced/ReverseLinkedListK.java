package LinkedList.Advanced;

import LinkedList.Basic.ReverseLinkedList2;
import LinkedList.Basic.ListNode;

/**
 * Created by Frank on 2016/12/18.
 */
public class ReverseLinkedListK {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if (head == null || head.next == null) return head;
        int m = 1;
        int n = k;
        int len = lengthCheck(head);
        int turn = len / k;
        while (turn != 0) {
            head = ReverseLinkedList2.reverseBetween(head, m, n);
            m += k;
            n += k;
            turn--;
        }
        return head;
    }
    private int lengthCheck(ListNode head) {
        int result = 0;
        while (head != null) {
            head = head.next;
            result++;
        }
        return result;
    }

    /**
     * 2017/03/28 更新
     * 下面是同样的做法，就是写法不太一样
     * 第二次做的时候写的，犯了很多小错误
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        head = dummy.next;
        int time = length / k;
        int m = 1;
        while (m < time * k + 1) {
            int n = m + k - 1;
            head = reverseMN(head, m, n);
            m += k;
        }
        return head;
    }
    private ListNode reverseMN (ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (m != 1) {
            head = head.next;
            m--;
        }
        ListNode prevM = head;
        ListNode mNode = head.next;
        head = dummy;
        while (n != 0) {
            head = head.next;
            n--;
        }
        ListNode nNode = head;
        ListNode postN = head.next;
        nNode = reverse(mNode, postN);
        prevM.next = nNode;
        return dummy.next;
    }
    private ListNode reverse (ListNode head, ListNode end) {
        if (head == end) return head;
        ListNode prev = end;
        while (head != end) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}