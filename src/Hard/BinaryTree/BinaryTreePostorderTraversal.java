package Hard.BinaryTree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by menghan on 2017/6/23.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode previsit=null;
        List<Integer> list=new ArrayList<>();
        TreeNode tmp=root;
        while(!stack.isEmpty()||tmp!=null){
            while(tmp!=null){
                stack.push(tmp);
                tmp=tmp.left;
            }
            tmp=stack.peek();
            if(tmp.right==null||previsit==tmp.right){
                list.add(tmp.val);
                previsit=tmp;
                stack.pop();
                tmp=null;
            }
            else tmp=tmp.right;
        }
        return list;
    }
}
