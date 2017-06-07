package Medium.Math;

/**
 * Created by 28479 on 2017/6/7.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) return i;
        }
        return nums.length-1;
    }
}
