package Easy;

/**
 * Created by 28479 on 2017/6/3.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int key=nums[0];
        int len=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=key) {
                nums[len++] = nums[i];
                key = nums[i];
            }
        }
        return len;
    }
}
