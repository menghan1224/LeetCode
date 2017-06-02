package Easy;

/**
 * Created by menghan on 2017/6/2.
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count=0;
        int temp=n;
        while(temp!=0) {
            temp=temp&(temp-1);
            count++;
        }
        return count;
    }
}
