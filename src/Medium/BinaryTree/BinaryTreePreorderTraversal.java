package Medium.BinaryTree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 28479 on 2017/6/6.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                list.add(root.val);
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop().right;
            }
        }
        return list;
    }
}
