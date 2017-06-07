package Medium.Array;

/**
 * Created by 28479 on 2017/6/7.
 */
public class FindMinimumInRotateArray {
    public int findMin(int[] nums) {
        return getMin(nums,0,nums.length-1);
    }
    public int getMin(int[] nums,int begin, int end){
        if(begin>=end)
            return nums[begin];
        int mid=(begin+end)/2;
        if(nums[mid]<nums[end]) return getMin(nums,begin,mid);
        else return getMin(nums,mid+1,end);
    }
}
