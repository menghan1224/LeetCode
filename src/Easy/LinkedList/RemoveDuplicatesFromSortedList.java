package Easy.LinkedList;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/6/2.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        int value=head.val;
        ListNode next=head.next;
        ListNode pre=head;
        while(next!=null){
            if(next.val==value){
                pre.next=next.next;
                next.next=null;
                next=pre.next;
            }else{
                value=next.val;
                pre=pre.next;
                next=next.next;
            }
        }
        return head;
    }
}
