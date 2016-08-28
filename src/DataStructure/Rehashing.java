package DataStructure;

/**
 * Created by Frank on 16/8/27.
 */
public class Rehashing {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if(hashTable == null || hashTable.length == 0){
            return hashTable;
        }
        int len = hashTable.length;
        int newcapacity = len * 2;
        ListNode[] result = new ListNode[newcapacity];
        for(int i = 0; i < len; ++i){
            while(hashTable[i] != null){
                int hashcode
                        = (hashTable[i].val % newcapacity + newcapacity) % newcapacity;
                if(result[hashcode] == null){
                    result[hashcode] = new ListNode(hashTable[i].val);
                } else {
                    ListNode newNode = new ListNode(hashTable[i].val);
                    newNode.next = result[hashcode];
                    result[hashcode] = newNode;
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        return result;
    }
};

