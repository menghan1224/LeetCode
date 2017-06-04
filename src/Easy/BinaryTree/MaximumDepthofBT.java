package Easy.BinaryTree;

import DataStructure.TreeNode;

/**
 * Created by 28479 on 2017/6/1.
 */
public class MaximumDepthofBT {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        else return Math.max(1+maxDepth(root.left),1+maxDepth(root.right));
    }
}
