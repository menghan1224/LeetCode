package Medium.BinaryTree;

import DataStructure.TreeNode;

/**
 * Created by 28479 on 2017/6/7.
 */
public class SumRootToLeafNumbers {
    int sum=0;
    public static void main(String[] args){
        new SumRootToLeafNumbers().sumNumbers(new TreeNode(9));
    }
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
}
