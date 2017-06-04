package Easy.BinaryTree;

import DataStructure.TreeNode;

/**
 * Created by menghan on 2017/6/2.
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=toBST(nums,0,nums.length-1);
        return root;
    }
    public TreeNode toBST(int[] nums,int begin,int end){
        if(begin>end) return null;
        int mid=(begin+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=toBST(nums,begin,mid-1);
        root.right=toBST(nums,mid+1,end);
        return root;
    }
}
