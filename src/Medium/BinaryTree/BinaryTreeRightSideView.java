package Medium.BinaryTree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/7.
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        searchView(list,0,root);
        return list;
    }
    public void searchView(List<Integer> list,int depth,TreeNode root){
        if(root==null) return;
        if(depth==list.size()) list.add(root.val);
        searchView(list,depth+1,root.right);
        searchView(list,depth+1,root.left);
    }
}
