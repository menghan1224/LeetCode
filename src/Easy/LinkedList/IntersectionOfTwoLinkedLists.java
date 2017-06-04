package Easy.LinkedList;

import DataStructure.ListNode;

/**
 * Created by menghan on 2017/6/4.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA=0;
        int countB=0;
        ListNode tmpA=headA;
        ListNode tmpB=headB;
        while(tmpA!=null||tmpB!=null){
            if(tmpA!=null){
                countA++;
                tmpA=tmpA.next;
            }
            if(tmpB!=null){
                countB++;
                tmpB = tmpB.next;
            }
        }
        ListNode shortList=countA>countB?headB:headA;
        ListNode longList=countA>countB?headA:headB;
        int step=Math.abs(countA-countB);
        while(step-->0){
            longList=longList.next;
        }
        while(shortList!=null){
            if(longList==shortList) return longList;
            longList=longList.next;
            shortList=shortList.next;
        }
        return null;
    }
}
