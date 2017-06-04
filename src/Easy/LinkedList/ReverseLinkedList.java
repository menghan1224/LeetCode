package Easy.LinkedList;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/6/2.
 */
public class ReverseLinkedList {
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        ListNode tmp=new ReverseLinkedList().reverseList(head);
        while(tmp!=null){
            System.out.print(tmp.val);
            tmp=tmp.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre = head;
        ListNode next= head.next;
        head.next=null;
        while(next!=null){
            ListNode tmp = next.next;
            next.next=pre;
            pre=next;
            next=tmp;
        }
        return pre;
    }
}
