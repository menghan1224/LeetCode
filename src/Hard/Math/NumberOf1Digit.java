package Hard.Math;

/**
 * Created by menghan on 2017/6/27.
 */
public class NumberOf1Digit {
    public static void main(String[] args){
        System.out.println(new NumberOf1Digit().countDigitOne(1000));
    }
    public int countDigitOne(int n) {
       int cnt=0;
       for(int m=1;m<=n;m*=10){
           long a=n/m;
           long b=a%m;
           cnt+=(a+8)/10*m+(a%10==1?b+1:0);
       }
       return cnt;
    }
}
