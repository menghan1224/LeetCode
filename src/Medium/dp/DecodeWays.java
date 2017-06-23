package Medium.dp;

/**
 * Created by menghan on 2017/6/23.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        if(s.length()==0) return 0;
        if(s.length()==1) return s.charAt(0)=='0'?0:1;
        dp[0]=s.charAt(0)=='0'?0:1;
        dp[1]=(s.charAt(0)!='0'&&s.charAt(1)!='0'?1:0)+((s.charAt(0)!='0'&&((s.charAt(0)-'0')*10+s.charAt(1)-'0')<=26)?1:0);
        for(int i=2;i<s.length();i++){
            if(s.charAt(i)!='0') dp[i]+=dp[i-1];
            if(s.charAt(i-1)!='0'&&((s.charAt(i-1)-'0')*10+s.charAt(i)-'0')<=26) dp[i]+=dp[i-2];
        }
        return dp[s.length()-1];
    }
}
