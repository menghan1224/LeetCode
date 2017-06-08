package Medium.BinaryTree;

import DataStructure.TreeNode;

/**
 * Created by 28479 on 2017/6/8.
 */
public class FlatternBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
                TreeNode pre = root.left;
                while(pre.right!=null)
                    pre = pre.right;
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
