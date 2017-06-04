package Easy.LinkedList;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/6/2.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode tmp;
        if(l1.val<l2.val){
            tmp=l1;
            tmp.next=mergeTwoLists(l1.next,l2);
        }
        else{
            tmp=l2;
            tmp.next=mergeTwoLists(l1,l2.next);
        }
        return tmp;
    }
}
