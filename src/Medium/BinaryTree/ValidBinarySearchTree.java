package Medium.BinaryTree;

import DataStructure.TreeNode;

/**
 * Created by 28479 on 2017/6/17.
 */
public class ValidBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return validBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean validBst(TreeNode root,long min,long max){
        if(root==null) return true;
        if(root.val<=min||root.val>=max) return false;
        return validBst(root.left,min,root.val)&&validBst(root.right,root.val,max);
    }
}
