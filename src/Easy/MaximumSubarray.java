package Easy;

/**
 * Created by menghan on 2017/6/2.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            nums[i]=Math.max(nums[i],nums[i]+nums[i-1]);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) max=nums[i];
        }
        return max;
    }
}
