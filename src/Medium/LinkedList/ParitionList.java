package Medium.LinkedList;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/6/12.
 */
public class ParitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode mark=dummyHead;
        while(mark.next!=null&&mark.next.val<x){
            mark=mark.next;
        }
        ListNode pre=mark.next;
        ListNode cur=null;
        if(pre!=null) {
            cur = pre.next;
        }
        while(cur!=null){
            if(cur.val>=x){
                pre=pre.next;
                cur=cur.next;
            }else{
                ListNode tmp=cur;
                pre.next=cur.next;
                cur.next=mark.next;
                mark.next=cur;
                cur=pre.next;
            }
        }
        return dummyHead.next;
    }
}
