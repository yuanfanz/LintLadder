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
        // write your code here
        if(head == null){
            return null;
        }
        copyNode(head);
        copyPointer(head);
        return split(head);
    }
    private void copyNode(RandomListNode head){
        if (head == null) return;
        while (head != null) {
            RandomListNode tmp = head.next;
            RandomListNode newNode = new RandomListNode(head.label);
            head.next = newNode;
            newNode.next = tmp;
            head = head.next.next;
        }
    }
    private void copyPointer(RandomListNode head){
        if (head == null) return;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    private RandomListNode split(RandomListNode head){
        if (head == null) return null;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newHead = dummy;
        while (head != null) {
            newHead.next = head.next;
            head.next = head.next.next;
            newHead = newHead.next;
            head = head.next;
        }
        return dummy.next;
    }
}
