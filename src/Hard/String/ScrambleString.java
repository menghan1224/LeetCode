package Hard.String;

/**
 * Created by menghan on 2017/6/27.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int len=s1.length();
        boolean[][][] dp=new boolean[len][len][len+1];
        for(int i=len-1;i>=0;i--){
            for(int j=len-1;j>=0;j--){
                for(int k=1;k<=len-Math.max(i,j);k++){
                    if(s1.substring(i,i+k).equals(s2.substring(j,j+k))) dp[i][j][k]=true;
                    else{
                        for(int l=1;l<k;l++){
                            if((dp[i][j][l]&&dp[i+l][j+l][k-l])||(dp[i+l][j][k-l]&&dp[i][j+k-l][l])){
                                dp[i][j][k]=true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
    }
}
