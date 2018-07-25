package Exer;

import DataStructure.TreeNode;

/**
 * Created by menghan on 2017/7/3.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymme(root,root);
    }
    public boolean isSymme(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null) return true;
        if(root1==null||root2==null) return false;
        if(root1.val!=root2.val) return false;
        return isSymme(root1.left,root2.right)&&isSymme(root1.right,root2.left);
    }
}
