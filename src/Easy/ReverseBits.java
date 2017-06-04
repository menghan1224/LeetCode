package Easy;

/**
 * Created by menghan on 2017/6/4.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        long x=0;
        int k=32;
        while(k-->0){
            x=x<<1;
            x|=n&1;
            n=n>>1;
        }
        return (int)x;
    }
}
