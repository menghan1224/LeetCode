package Easy;

/**
 * Created by menghan on 2017/6/2.
 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n>0&&(n&(n-1))==0;
    }
}
