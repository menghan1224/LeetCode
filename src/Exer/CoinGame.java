package Exer;

/**
 * Created by menghan on 2017/10/18.
 */
public class CoinGame {
    public static void main(String[] args) {
        System.out.println(solution("1,2,4"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(",");
        int arr[] = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        // 返回处理后的结果
        return findRes(arr)+"";
    }
    private static boolean findRes(int[] values){
        if(values.length<=2) return true;
        int[] dp = new int[values.length+1];
        int len = values.length;
        dp[len]=0;
        //left 1 coin,TAKE
        dp[len-1]=values[len-1];
        //left 2 coin,take both
        dp[len-2]=values[len-1]+values[len-2];
        //left 3 coin,take both
        dp[len-3]=values[len-3]+values[len-2];
        for(int i=len-4;i>=0;i--){
            int take1 = values[i] + Math.min(dp[i+2],dp[i+3]);
            int take2 = values[i] + values[i+1] + Math.min(dp[i+3],dp[i+4]);
            dp[i] = Math.max(take1,take2);
        }
        int sum = 0;
        for(int num:values) sum+=num;
        return dp[0]>sum-dp[0];
    }
}
