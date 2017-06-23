package Medium.Math;

/**
 * Created by menghan on 2017/6/23.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor==0) return Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
        int res=0;
        boolean flag=((dividend^divisor)>>>31==1)?true:false;
        int k=0;
        long temp1=Math.abs((long)dividend);
        long temp2=Math.abs((long)divisor);
        while(temp2<=(temp1>>1)){
            temp2=temp2<<1;
            k++;
        }
        while(k>=0){
            if(temp1>=temp2) {
                res += 1 << k;
                temp1 -= temp2;
            }
            temp2>>=1;
            k--;
        }
        return flag==true?-res:res;
    }
}
