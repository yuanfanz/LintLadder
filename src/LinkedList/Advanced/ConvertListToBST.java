package LinkedList.Advanced;

/**
 * Created by Frank on 16/8/9.
 */
public class ConvertListToBST {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        current = head;
        int len = getLen(current);
        return helper(len);
    }
    private TreeNode helper(int len){
        if(len <= 0){
            return null;
        }
        TreeNode left = helper(len / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = helper(len - 1 - len / 2);

        root.left = left;
        root.right = right;

        return root;
    }
    private int getLen(ListNode head){
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
