package Hard.BinaryTree;

import DataStructure.TreeNode;

/**
 * Created by menghan on 2017/6/29.
 */
public class BinaryTreeMaximumPathSum {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }
    public int getMax(TreeNode root){
        if(root==null) return 0;
        int val=root.val;
        int leftMax=getMax(root.left);
        if(leftMax>0) val+=leftMax;
        int rightMax=getMax(root.right);
        if(rightMax>0) val+=rightMax;
        if(val>max) max=val;
        return Math.max(root.val,Math.max(root.val+leftMax,root.val+rightMax));
    }
}
