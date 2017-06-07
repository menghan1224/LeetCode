package Medium.dp;

import java.util.Arrays;

/**
 * Created by 28479 on 2017/6/7.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args){

       System.out.print(Arrays.binarySearch(new int[]{2,5,1},0,3,3));
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }
        return len;
    }
}
