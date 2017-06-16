package Medium.LinkedList;

import DataStructure.RandomListNode;

/**
 * Created by 28479 on 2017/6/16.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
    /*第一步:在OldList的每个节点后面都插入一个copyNode(拷贝链表的结点)*/
        RandomListNode nowNode = head;
        while (nowNode != null){
            RandomListNode copyNode = new RandomListNode(nowNode.label);
            copyNode.next = nowNode.next;
            nowNode.next = copyNode;
            nowNode = nowNode.next.next;
        }

    /*第二步:确定NewList的每个节点,真正关联到的Random结点是哪个，
     * 		因为第一步已经把所有NewList上的结点都建立了*/
        nowNode = head;
        while (nowNode != null){
            if (nowNode.random != null){
                nowNode.next.random = nowNode.random.next;
            }
            nowNode = nowNode.next.next;
        }

    /*第三步：还原OldList的next为一开始的next结点
     * 		并拼接NewList的next到它真正所应该关联的next结点
     * 		即：保持老链表OldList不变，拼接新链表NewList！
     * */
        RandomListNode pHead = new RandomListNode(0);
        pHead.next = head;
        RandomListNode newlist = pHead;

        nowNode = head;
        while (nowNode != null){
            pHead.next = nowNode.next;
            nowNode.next = pHead.next.next;
            pHead = pHead.next;
            nowNode = nowNode.next;
        }
        return newlist.next;
    }
}
