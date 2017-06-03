package Easy;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/3.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<String>();
        searchPath(root,"",list);
        return list;

    }
    public void searchPath(TreeNode root,String path,List<String> list){
        if(root!=null){
            if(root.left==null&&root.right==null){
                list.add(path+ root.val);
            }
            searchPath(root.left,path+root.val+"->",list);
            searchPath(root.right,path+root.val+"->",list);
        }
    }
}
