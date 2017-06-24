package Hard.Array;

/**
 * Created by menghan on 2017/6/24.
 */
public class FindMinimumInRotateArrayII {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int begin=0,end=nums.length-1;
        while(begin<end&&nums[begin]>=nums[end]){
            int mid=(begin+end)/2;
            if(nums[mid]<nums[begin]) end=mid;
            else if(nums[mid]==nums[begin]) begin+=1;
            else begin=mid+1;
        }
        return nums[begin];
    }
}
