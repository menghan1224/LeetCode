package Hard.dp;

/**
 * Created by menghan on 2017/6/28.
 */
public class JumpGameII {
    public static void main(String[] args){
        System.out.println(new JumpGameII().jump(new int[]{2,3,1,1,4}));
    }
    public int jump(int[] nums) {
        int ret = 0;
        int curMax = 0;
        int curRch = 0;
        for(int i = 0; i < nums.length; i ++)
        {
            if(curRch < i)
            {
                ret ++;
                curRch = curMax;
            }
            curMax = Math.max(curMax, nums[i]+i);
        }
        return ret;
    }
}
