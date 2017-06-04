package Easy.Array;

/**
 * Created by 28479 on 2017/6/1.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int pos=0;
        for(int num:nums){
            if(num!=0){
                nums[pos++]=num;
            }
        }
        for(int i=pos;i<nums.length;i++)
            nums[pos]=0;
    }
}
