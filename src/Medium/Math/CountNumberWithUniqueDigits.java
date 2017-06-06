package Medium.Math;

/**
 * Created by 28479 on 2017/6/6.
 */
public class CountNumberWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n>10)
            n=10;
        int[] res=new int[n];
        res[0]=10;
        int mark=9;
        int k=9;
        for(int i=1;i<n;i++)
        {
            mark*=k--;
            res[i]=res[i-1]+mark;
        }
        return res[n-1];
    }
}
