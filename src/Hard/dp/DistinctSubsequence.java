package Hard.dp;

/**
 * Created by menghan on 2017/6/24.
 */
public class DistinctSubsequence {
    public static void main(String[] args){
        System.out.println(new DistinctSubsequence().numDistinct("ccc","c"));
    }
    public int numDistinct(String s, String t) {
        if(s==null||t==null||s.length()<t.length()) return 0;
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++) dp[i][0]=1;
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=Math.min(i,t.length());j++){
                dp[i][j]=dp[i-1][j]+(s.charAt(i-1)==t.charAt(j-1)?dp[i-1][j-1]:0);
            }
        }
        return dp[s.length()][t.length()];
    }
}
