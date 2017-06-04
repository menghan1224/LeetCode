package Easy.BinaryTree;

import DataStructure.TreeNode;

/**
 * Created by menghan on 2017/6/2.
 */
public class IsSameTree {
        public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p!=null||q==null) return false;
        if(p.val==q.val) return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        return  false;

    }

}
