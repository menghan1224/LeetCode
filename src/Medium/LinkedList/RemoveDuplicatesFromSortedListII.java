package Medium.LinkedList;

import DataStructure.ListNode;

/**
 * Created by 28479 on 2017/6/14.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }else{
                pre.next=cur.next;
            }
        }
        return dummyHead.next;
    }
}
