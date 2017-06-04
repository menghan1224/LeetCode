package Easy.BinaryTree;

import DataStructure.TreeNode;

/**
 * Created by 28479 on 2017/6/3.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return canSymmetric(root.left,root.right);

    }
    public boolean canSymmetric(TreeNode tree1,TreeNode tree2)
    {
        if(tree1==null&&tree2==null)
            return true;
        else if(tree1==null||tree2==null)
            return false;
        else if(tree1.val!=tree2.val)
            return false;
        else return canSymmetric(tree1.left,tree2.right)&&canSymmetric(tree1.right,tree2.left);

    }
}
