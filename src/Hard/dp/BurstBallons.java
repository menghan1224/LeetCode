package Hard.dp;

/**
 * Created by menghan on 2017/6/23.
 */
public class BurstBallons {
    public int maxCoins(int[] nums) {
        int[][] dp=new int[nums.length+2][nums.length+2];
        int[] res=new int[nums.length+2];
        res[0]=1;
        res[res.length-1]=1;
        for(int i=0;i<nums.length;i++){
            res[i+1]=nums[i];
        }
        for(int i=2;i<res.length;i++){
            for(int j=0;j+i<res.length;j++){
                for(int k=j+1;k<j+i;k++){
                    dp[j][j+i]=Math.max(dp[j][j+i],dp[j][k]+dp[k][j+i]+res[j]*res[k]*res[j+i]);
                }
            }
        }
        return dp[0][res.length-1];
    }
}
