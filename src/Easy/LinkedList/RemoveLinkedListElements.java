package Easy.LinkedList;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/6/4.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode mark = new ListNode(-1);
        mark.next=head;
        ListNode pre=mark;
        ListNode nxt=head;
        while(nxt!=null){
            if(nxt.val==val){
                pre.next=nxt.next;
                nxt=nxt.next;
            }else{
                pre=pre.next;
                nxt=nxt.next;
            }
        }
        return mark.next;
    }
}
