package Medium.BinaryTree;

import DataStructure.TreeLinkNode;

/**
 * Created by 28479 on 2017/6/8.
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode nextnode=root.next;
        TreeLinkNode next=null;
        while(nextnode!=null&&next==null){
            if(nextnode.left!=null){
                next=nextnode.left;
            }else if(nextnode.right!=null){
                next=nextnode.right;
            }
            nextnode=nextnode.next;
        }
        if(root.left!=null){
            if(root.right!=null){
                root.left.next=root.right;
                root.right.next=next;
            }
        }
        if(root.right!=null){
            root.right.next=next;
        }
        connect(root.left);
        connect(root.right);
    }
}
