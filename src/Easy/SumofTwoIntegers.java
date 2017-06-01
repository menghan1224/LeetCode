package Easy;

/**
 * Created by 28479 on 2017/6/1.
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        return b==0?a:getSum(a^b,(a&b)<<1);
    }
}
