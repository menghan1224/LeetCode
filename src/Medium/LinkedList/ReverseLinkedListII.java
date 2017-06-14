package Medium.LinkedList;

import DataStructure.ListNode;

/**
 * Created by 28479 on 2017/6/14.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        m--;
        n--;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode newHead=dummyHead;
        ListNode reHead=head;
        ListNode tail=head;
        while(m-->0&&n-->0){
             newHead=newHead.next;
            reHead=reHead.next;
            tail=tail.next;
        }
        while(n-->0){
            tail=tail.next;
        }
        ListNode newTail=tail.next;
        ListNode tmp=reHead;
        ListNode tmpnxt=reHead.next;
        tmp.next=null;
        while(tmp!=tail){
            ListNode temp=tmpnxt.next;
            tmpnxt.next=tmp;
            tmp=tmpnxt;
            tmpnxt=temp;
        }
        newHead.next=tmp;
        reHead.next=newTail;
        return dummyHead.next;
    }
}
