package Medium.BinaryTree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by menghan on 2017/6/12.
 */
public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return getTree(1,n);
    }
    public List<TreeNode> getTree(int begin,int end){
        List<TreeNode> list=new ArrayList<>();
        if(begin>end){
            list.add(null);
            return list;
        }
        for(int i=begin;i<=end;i++){
            List<TreeNode> left=getTree(begin,i-1);
            List<TreeNode> right=getTree(i+1,end);
            for(int m=0;m<left.size();m++){
                for(int n=0;n<right.size();n++){
                    TreeNode root=new TreeNode(i);
                    list.add(root);
                    root.left=left.get(m);
                    root.right=right.get(n);
                }
            }
        }
        return list;
    }
}
