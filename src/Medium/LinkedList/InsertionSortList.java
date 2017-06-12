package Medium.LinkedList;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/6/11.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead=new ListNode(-1);
        if(head==null) return null;
        ListNode pre=dummyHead;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            while(pre.next!=null&&pre.next.val<cur.val){
                pre=pre.next;
            }
            cur.next=pre.next;
            pre.next=cur;
            pre=dummyHead;
            cur=next;
        }
        return dummyHead.next;
    }
}
