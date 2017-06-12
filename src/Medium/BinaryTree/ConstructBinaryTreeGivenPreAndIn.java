package Medium.BinaryTree;

import DataStructure.TreeNode;

/**
 * Created by menghan on 2017/6/12.
 */
public class ConstructBinaryTreeGivenPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }
    public TreeNode build(int[] preorder,int pbegin,int pend,int[] inorder,int ibegin,int iend){
        if(pbegin>pend||ibegin>iend) return null;
        int key=preorder[pbegin];
        TreeNode root=new TreeNode(key);
        int len=0;
        int i=ibegin;
        for(;i<=iend;i++){
            if(inorder[i]!=key) len++;
            else break;
        }
        root.left=build(preorder,pbegin+1,pbegin+len,inorder,ibegin,i-1);
        root.right=build(preorder,pbegin+len+1,pend,inorder,i+1,iend);
        return root;
    }

}
