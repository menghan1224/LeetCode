package Medium.BinaryTree;

import DataStructure.TreeLinkNode;

/**
 * Created by 28479 on 2017/6/7.
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode current=root;
        while(current!=null) {
            TreeLinkNode tmp=current;
            while (tmp != null) {
                if (tmp.left != null) tmp.left.next = tmp.right;
                if (tmp.right!=null&&tmp.next != null) tmp.right.next = tmp.next.left;
                tmp = tmp.next;
            }
            current=current.left;
        }
    }
}
