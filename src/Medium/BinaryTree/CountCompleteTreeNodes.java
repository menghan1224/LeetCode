package Medium.BinaryTree;

import DataStructure.TreeNode;

/**
 * Created by 28479 on 2017/6/15.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int left=leftDepth(root);
        int right=rightDepth(root);
        if(left==right) return 1<<left-1;
        else return countNodes(root.left)+countNodes(root.right)+1;
    }
    public int leftDepth(TreeNode root){
        int depth=0;
        while(root!=null){
            root=root.left;
            depth++;
        }
        return depth;
    }
    public int rightDepth(TreeNode root){
        int depth=0;
        while(root!=null){
            root=root.right;
            depth++;
        }
        return depth;
    }
}
