package Easy.dp;

/**
 * Created by 28479 on 2017/6/14.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int reach=0;
        int i=0;
        for(;i<nums.length&&i<=reach;i++){
            reach=Math.max(i+nums[i],reach);
        }
        return i==nums.length;
    }
}
