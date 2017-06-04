package Easy.BinaryTree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by menghan on 2017/6/2.
 */
public class BinaryTreeLeverOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int key=queue.size();
            List<Integer> sublist=new ArrayList<>();
            for(int i=0;i<key;i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            list.add(0,sublist);
        }
        return list;
    }
}
