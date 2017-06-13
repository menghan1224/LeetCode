package Medium.LinkedList;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/6/13.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        ListNode tmpA=headA;
        ListNode tmpB=headB;
        while(tmpA!=null){
            lenA++;
            tmpA=tmpA.next;
        }
        while(tmpB!=null){
            lenB++;
            tmpB=tmpB.next;
        }
        int diff=Math.abs(lenA-lenB);
        ListNode Long=lenA>lenB?headA:headB;
        ListNode Short=lenA<lenB?headA:headB;
        while(diff-->0){
            Long=Long.next;
        }
        while(Long!=null){
            if(Long==Short) return Long;
            Long=Long.next;
            Short=Short.next;
        }
        return null;
    }
}
