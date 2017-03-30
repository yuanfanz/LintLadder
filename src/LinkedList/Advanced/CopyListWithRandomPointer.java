package LinkedList.Advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Frank on 16/8/12.
 */
public class CopyListWithRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode nee = dummy;
        RandomListNode memo = new RandomListNode(0);
        memo.next = head;
        while(head != null){
            RandomListNode newNode = new RandomListNode(head.label);
            nee.next = newNode;
            map.put(head, newNode);
            nee = nee.next;
            head = head.next;
        }
        nee = dummy.next;
        head = memo.next;
        while(head != null){
            if(head.random != null){
                nee.random = map.get(head.random);
            }
            head = head.next;
            nee = nee.next;
        }
        return dummy.next;
    }

    /**
     * O(1)的空间复杂度
     * 更加巧妙的办法
     */
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copy2(RandomListNode head) {
        if (head == null) return head;
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        while (head != null) {
            RandomListNode node = new RandomListNode(head.label);
            node.next = head.next;
            head.next = node;
            head = head.next.next;
        }
        head = dummy.next;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = dummy.next;
        RandomListNode newHead = dummy;
        while (head != null) {
            newHead.next = head.next;
            newHead = newHead.next;
            head = head.next.next;
        }
        return dummy.next;
    }
}
