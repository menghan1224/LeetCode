package Easy.LinkedList;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/6/4.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            slow.next=reverseList(slow.next);
            slow=slow.next;

        }
        else{
            slow=reverseList(slow);
        }
        while(slow!=null){
            if(head.val==slow.val){
                head=head.next;
                slow=slow.next;
            }
            else return false;
        }
        return true;


    }
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode pre=head;
        ListNode next=pre.next;
        pre.next=null;
        ListNode tmp;
        while(next!=null)
        {
            tmp=next.next;
            next.next=pre;
            pre=next;
            next=tmp;
        }
        return pre;

    }
}
