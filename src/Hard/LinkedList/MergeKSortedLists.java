package Hard.LinkedList;

import DataStructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by menghan on 2017/6/28.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode dummy=new ListNode(-1);
        ListNode tmp=dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode node:lists){
            if(node!=null){
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()){
            ListNode node=queue.poll();
            tmp.next=node;
            tmp=tmp.next;
            if(node.next!=null) queue.offer(node.next);
        }
        return dummy.next;
    }
}
