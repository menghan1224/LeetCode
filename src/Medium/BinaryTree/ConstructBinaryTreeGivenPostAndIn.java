package Medium.BinaryTree;

import DataStructure.TreeNode;

/**
 * Created by menghan on 2017/6/12.
 */
public class ConstructBinaryTreeGivenPostAndIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        TreeNode root=build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return root;
    }
    public TreeNode build(int[] inorder,int ibegin,int iend,int[] postorder,int pbegin,int pend){
        if(ibegin>iend||pbegin>pend) return null;
        int key=postorder[pend];
        TreeNode root=new TreeNode(postorder[pend]);
        int i=ibegin;
        for(;i<=iend;i++){
            if(inorder[i]==key) break;
        }
        root.left=build(inorder,ibegin,i-1,postorder,pbegin,pbegin+i-1-ibegin);
        root.right=build(inorder,i+1,iend,postorder,pbegin+i-ibegin,pend-1);
        return root;
    }
}
