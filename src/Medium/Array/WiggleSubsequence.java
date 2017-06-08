package Medium.Array;

/**
 * Created by 28479 on 2017/6/8.
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int count = 1;
        if (nums.length<=0) return nums.length;
        Boolean pre=null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1] &&(pre==null||!pre)) {
                pre = true;
                count++;
            } else if (nums[i] > nums[i - 1] &&(pre==null||pre)) {
                pre = false;
                count++;
            }
        }
        return count;
    }
}
