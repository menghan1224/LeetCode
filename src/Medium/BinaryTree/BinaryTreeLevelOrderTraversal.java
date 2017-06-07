package Medium.BinaryTree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 28479 on 2017/6/7.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list=new ArrayList<List<Integer>>();
            if(root==null) return list;
            List<Integer> sublist=new ArrayList<>();
            Queue<TreeNode> queue=new LinkedList<TreeNode>();
            queue.offer(root);
            int parentSize=1;
            int childSize=0;
            while(!queue.isEmpty()){
                TreeNode tmp=queue.poll();
                sublist.add(tmp.val);
                parentSize--;
                if(tmp.left!=null){
                    queue.offer(tmp.left);
                    childSize++;
                }
                if(tmp.right!=null){
                    queue.offer(tmp.right);
                    childSize++;
                }
                if(parentSize==0){
                    parentSize=childSize;
                    childSize=0;
                    list.add(new ArrayList<>(sublist));
                    sublist.clear();
                }
            }
            return list;
    }
}
