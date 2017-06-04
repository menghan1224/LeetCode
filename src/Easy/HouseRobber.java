package Easy;

/**
 * Created by menghan on 2017/6/2.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length>1)
        nums[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            nums[i]=Math.max(nums[i-2]+nums[i],nums[i-1]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
          if(nums[i]>max) max=nums[i];
        }
        return max;
    }
}
