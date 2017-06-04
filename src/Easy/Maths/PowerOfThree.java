package Easy.Maths;

/**
 * Created by menghan on 2017/6/2.
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n)/Math.log10(3))%1==0;
    }
}
