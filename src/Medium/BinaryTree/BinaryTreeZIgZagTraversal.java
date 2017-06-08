package Medium.BinaryTree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/8.
 */
public class BinaryTreeZIgZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        getList(list,1,root);
        return list;
    }
    public void getList(List<List<Integer>> list,int level,TreeNode root){
        if(root==null) return;
        if(list.size()<level){
            List<Integer> sublist=new ArrayList<>();
            list.add(sublist);
        }
        List<Integer> tmpList=list.get(level-1);
        if(level%2==0){
            tmpList.add(0,root.val);
        }else{
            tmpList.add(root.val);
        }
        getList(list,level+1,root.left);
        getList(list,level+1,root.right);
    }
}
