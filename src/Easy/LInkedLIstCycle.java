package Easy;

import DataStructure.ListNode;

/**
 * Created by 28479 on 2017/6/3.
 */
public class LInkedLIstCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}
