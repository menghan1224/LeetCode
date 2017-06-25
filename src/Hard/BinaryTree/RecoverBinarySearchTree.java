package Hard.BinaryTree;

import DataStructure.TreeNode;

import java.util.TreeSet;

/**
 * Created by menghan on 2017/6/24.
 */
public class RecoverBinarySearchTree {
    TreeNode first;
    TreeNode second;
    TreeNode pre=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    public void inorderTraversal(TreeNode root){
        if(root==null) return;
        inorderTraversal(root.left);
        if(first==null&&pre.val>root.val) first=pre;
        if(first!=null&&pre.val>root.val) second=root;
        pre=root;
        inorderTraversal(root.right);
    }
}
