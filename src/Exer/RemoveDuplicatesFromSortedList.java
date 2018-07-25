package Exer;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/7/4.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        ListNode tmp;
        while(cur!=null){
            tmp=cur;
            while(tmp!=null&&tmp.val==cur.val){
                tmp=tmp.next;
            }
            cur.next=tmp;
            cur=tmp;
        }
        return head;
    }
}
