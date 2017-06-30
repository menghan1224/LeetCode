package Hard.dp;

/**
 * Created by menghan on 2017/6/29.
 */
public class InterleavingStrings {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        int m=s1.length(),n=s2.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s3.charAt(i)&&dp[i][0]) dp[i+1][0]=true;
        }
        for(int j=0;j<s2.length();j++){
            if(s2.charAt(j)==s3.charAt(j)&&dp[0][j]) dp[0][j+1]=true;
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                int k=i+j-1;
                if((s3.charAt(k)==s1.charAt(i-1)&&dp[i-1][j])||(s3.charAt(k)==s2.charAt(j-1)&&dp[i][j-1])) dp[i][j]=true;
            }
        }
        return dp[m][n];
    }
}
