package Medium.Math;

/**
 * Created by menghan on 2017/6/12.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] result=new int[n];
        result[0]=1;
        int index2=0,index3=0,index5=0;
        int count=1;
        for(int i=1;i<n;i++)
        {
            result[i]=min(result[index2]*2,result[index3]*3,result[index5]*5);
            if(result[i]==result[index2]*2)
                index2++;
            if(result[i]==result[index3]*3)
                index3++;
            if(result[i]==result[index5]*5)
                index5++;
        }

        return result[n-1];
    }
    public int min(int a,int b,int c)
    {
        int min=a<b?a:b;
        return min<c?min:c;
    }
}
