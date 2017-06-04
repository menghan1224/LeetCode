package Easy.LinkedList;

import DataStructure.ListNode;

/**
 * Created by 28479 on 2017/6/2.
 */
public class DeleteNodeinALInkedList {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
