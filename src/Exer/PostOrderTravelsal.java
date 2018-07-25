package Exer;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by menghan on 2017/7/3.
 */
public class PostOrderTravelsal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        TreeNode cur=root;
        TreeNode previsit=null;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.peek();
            if(cur.right==null||cur.right==previsit){
                res.add(stack.pop().val);
                previsit=cur;
                cur=null;
            }else{
                cur=cur.right;
            }
        }
        return res;
    }
}
