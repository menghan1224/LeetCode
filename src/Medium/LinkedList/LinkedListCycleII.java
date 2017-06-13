package Medium.LinkedList;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/6/12.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode mark=null;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
              mark=slow;
            }
        }
        if(mark==null) return null;
        while(mark!=head){
            head=head.next;
            mark=mark.next;
        }
        return mark;
    }
}
