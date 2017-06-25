package Hard.dp;

import sun.nio.cs.ext.MacHebrew;

/**
 * Created by menghan on 2017/6/24.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m;i++) dp[i][0]=i;
        for(int j=0;j<n;j++) dp[0][j]=j;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word1.charAt(i)==word2.charAt(j)) dp[i+1][j+1]=dp[i][j];
                else dp[i+1][j+1]= Math.min(dp[i][j],Math.min(dp[i+1][j],dp[i][j+1]))+1;
            }
        }
        return dp[m][n];
    }
}
