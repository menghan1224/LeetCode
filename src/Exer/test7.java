package Exer;

/**
 * Created by menghan on 2017/10/11.
 */
public class test7 {
    public static void main(String[] args) {
        System.out.println(solution("10,5,8,6,20,13,7,11"));
    }
    private static int count = Integer.MAX_VALUE;
    private static int n;
    private static int m;
    private static boolean[][] cache;
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(strs[i]);
        int sum = 0;
        for(int k:arr) sum+=k;
        if(sum%2!=0) return false+"";
        int tar = sum/2;
        int[][] dp = new int[arr.length+1][tar+1];
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=tar;j++){
                if(arr[i-1]>j) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i-1]]+arr[i-1]);
                }
            }
        }
        return dp[arr.length][tar]==tar?true+"":false+"";
    }

    public static int maxDiffSubArrays(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMin = new int[len];
        int[] leftMin = new int[len];
        int[] rightMax = new int[len];
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        int localMin = 0;
        int globalMin = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            localMax = Math.max(localMax + nums[i], nums[i]);
            globalMax = Math.max(localMax, globalMax);
            leftMax[i] = globalMax;

            localMin = Math.min(localMin + nums[i], nums[i]);
            globalMin = Math.min(localMin, globalMin);
            leftMin[i] = globalMin;
        }

        localMin = 0;
        globalMin = Integer.MAX_VALUE;
        localMax = 0;
        globalMax = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            localMin = Math.min(localMin + nums[i], nums[i]);
            globalMin = Math.min(localMin, globalMin);
            rightMin[i] = globalMin;

            localMax = Math.max(localMax + nums[i], nums[i]);
            globalMax = Math.max(localMax, globalMax);
            rightMax[i] = globalMax;
        }
        int leftMAX = Integer.MIN_VALUE;
        int rightMAX = Integer.MIN_VALUE;

        for (int i = 0; i < len - 1; i++) {
            leftMAX = Math.max(Math.abs(leftMax[i] - rightMin[i + 1]), leftMAX);
            rightMAX = Math.max(Math.abs(leftMin[i] - rightMax[i + 1]), rightMAX);
        }

        return Math.max(leftMAX, rightMAX);
    }
}
