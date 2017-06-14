package Medium.LinkedList;

import DataStructure.ListNode;

/**
 * Created by 28479 on 2017/6/14.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        ListNode mid=getMid(head);
        ListNode midnext=mid.next;
        mid.next=null;
        return mergelist(sortList(head),sortList(midnext));
    }
    public ListNode getMid(ListNode head)
    {
        ListNode tail=head;
        ListNode mid=head;
        while(tail.next!=null&&tail.next.next!=null)
        {
            mid=mid.next;
            tail=tail.next.next;
        }
        return mid;
    }
    public ListNode mergelist(ListNode t1,ListNode t2)
    {
        ListNode head=new ListNode(-1);
        ListNode mark=head;
        while(t1!=null&&t2!=null)
        {
            if(t1.val<t2.val) {
                mark.next = t1;

                t1=t1.next;
                mark=mark.next;
            }
            else
            {
                mark.next=t2;
                t2=t2.next;
                mark=mark.next;
            }
        }
        mark.next=t1!=null?t1:t2;
        return head.next;
    }
}
