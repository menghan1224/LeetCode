package Hard.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by menghan on 2017/6/24.
 */
public class CountOfSmallerAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        for(int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(0,count);
        }
        return res;
    }

    public int insertNode(TreeNode root, int val) {
        int thisCount = 0;
        while(true) {
            if(val <= root.val) {
                root.count++;
                if(root.left == null) {
                    root.left = new TreeNode(val); break;
                } else {
                    root = root.left;
                }
            } else {
                thisCount += root.count;
                if(root.right == null) {
                    root.right = new TreeNode(val); break;
                } else {
                    root = root.right;
                }
            }
        }
        return thisCount;
    }
}
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    int count = 1;
    public TreeNode(int val) {
        this.val = val;
    }
}
