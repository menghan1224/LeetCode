package Easy;

/**
 * Created by 28479 on 2017/6/3.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        return n==0?0:n/5+trailingZeroes(n/5);
    }
}
