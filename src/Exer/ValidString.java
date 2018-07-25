package Exer;

/**
 * Created by menghan on 2017/10/18.
 */
public class ValidString {
    public static void main(String[] args) {
        System.out.println(solution("22"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        int k = Integer.parseInt(line);
        long[][] dp = new long[k+1][2];
        dp[1][0]=3;
        for(int i=2;i<=k;i++){
            dp[i][0]=2*dp[i-1][0]+2*dp[i-1][1];
            dp[i][1]=dp[i-1][0];
        }
        // 返回处理后的结果
        return (dp[k][0]+dp[k][1])+"";
    }
}
