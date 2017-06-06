package Medium.dp;

/**
 * Created by 28479 on 2017/6/6.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] res=new int[n+1];
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                res[i]=Math.max(res[i],Math.max(j,res[j])*Math.max(i-j,res[i-j]));
            }
        }
        return res[n];
    }
}
