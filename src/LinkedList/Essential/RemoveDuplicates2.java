package LinkedList.Essential;

import LinkedList.Essential.*;

/**
 * Created by Frank on 16/8/3.
 */
public class RemoveDuplicates2 {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */

    /**
     * 自己写的一个版本, 可以通过91%的数据, 仍然有漏洞。
     */
    public LinkedList.Essential.ListNode deleteDuplicates(LinkedList.Essential.ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList.Essential.ListNode dummy = new LinkedList.Essential.ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null && head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                head = RemoveNodeByValue.removeElements(head, head.next.val);
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    /**
     * 正确的做法
     */
}