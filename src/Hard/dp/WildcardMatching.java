package Hard.dp;

/**
 * Created by menghan on 2017/7/1.
 */
public class WildcardMatching {
    public static void main(String[] args){
        System.out.println(new WildcardMatching().isMatch("","*"));
    }
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=0;i<n;i++){
            if(p.charAt(i)=='*') dp[0][i+1]=dp[0][i];
            else break;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?') dp[i+1][j+1]=dp[i][j];
                else if(p.charAt(j)=='*') dp[i+1][j+1]=dp[i][j+1]||dp[i+1][j]||dp[i][j];
            }
        }
        return dp[m][n];
    }
}
