package Medium.BinaryTree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 28479 on 2017/6/6.
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args){
        int a[]={1,2,3};
        int b[]=a;
        for(int num:b)
            System.out.print(num+" ");
        a[0]=8;
        for(int num:b)
            System.out.print(num+" ");
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<Integer> list=new ArrayList<>();
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            list.add(root.val);
            root=root.right;
        }
        return list;
    }
}
