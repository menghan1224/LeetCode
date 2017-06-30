package Hard.dp;

/**
 * Created by menghan on 2017/6/30.
 */
public class PalindromePartioning {
    public int minCut(String s) {
        int[] cut=new int[s.length()+1];
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        for(int i=0;i<cut.length;i++){
            cut[i]=len-i;
        }
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<2||dp[i+1][j-1])){
                    dp[i][j]=true;
                    cut[i]=Math.min(cut[i],cut[j+1]+1);
                }
            }
        }
        return cut[0]-1;
    }
}
