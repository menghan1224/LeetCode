package Exer;

/**
 * Created by menghan on 2017/8/1.
 */
public class SumOfTwo {
    public int getSum(int a, int b) {
        if(b!=0){
            return getSum(a^b,(a&b)<<1);
        }
        return a;
    }
}
