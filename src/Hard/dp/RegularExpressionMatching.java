package Hard.dp;

/**
 * Created by menghan on 2017/6/30.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean res[][]=new boolean[m+1][n+1];
        res[0][0]=true;
        for(int i=1;i<=n;i++){
            if(p.charAt(i-1)=='*'&&res[0][i-2]) res[0][i]=true;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(p.charAt(j)=='.') res[i+1][j+1]=res[i][j];
                else if(p.charAt(j)==s.charAt(i)) res[i+1][j+1]=res[i][j];
                else if(p.charAt(j)=='*'){
                    if(p.charAt(j-1)!=s.charAt(i)&&p.charAt(j-1)!='.') res[i+1][j+1]=res[i+1][j-1];
                    else{
                        res[i+1][j+1]=res[i][j+1]||res[i+1][j]||res[i+1][j-1];
                    }
                }
            }
        }
        return res[m][n];
    }
}
