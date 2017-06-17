package Medium.LinkedList;

import DataStructure.ListNode;

/**
 * Created by 28479 on 2017/6/16.
 */
public class ReorderList {
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        new ReorderList().reorderList(head);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }

    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode tmp=slow.next;
        slow.next=null;
        ListNode reverse=reverse(tmp);
        while(head!=null&&reverse!=null){
            ListNode temp=reverse.next;
            reverse.next=head.next;
            head.next=reverse;
            reverse=temp;
            head=head.next.next;
        }

    }
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode pre=head;
        ListNode nxt=head.next;
        pre.next=null;
        while(nxt!=null){
            ListNode tmp=nxt.next;
            nxt.next=pre;
            pre=nxt;
            nxt=tmp;
        }
        return pre;
    }
}
