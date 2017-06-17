package Medium.LinkedList;

import DataStructure.ListNode;

/**
 * Created by 28479 on 2017/6/16.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode tail=dummyHead;
        int len=0;
        while(tail!=null&&tail.next!=null){
            tail=tail.next;
            len++;
        }
        int step=len-k;
        ListNode newHead=dummyHead;
        while(step-->0){
            newHead=newHead.next;
        }
        ListNode temp=newHead.next;
        newHead.next=null;
        dummyHead.next=temp;
        tail.next=head;
        return dummyHead.next;
    }
}
