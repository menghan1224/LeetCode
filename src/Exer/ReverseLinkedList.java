package Exer;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/7/3.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode cur=head;
        ListNode nxt=head.next;
        head.next=null;
        while(nxt!=null){
            ListNode tmp=nxt.next;
            nxt.next=cur;
            cur=nxt;
            nxt=tmp;
        }
        return cur;
    }
}
