package Easy.Maths;

/**
 * Created by 28479 on 2017/6/3.
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return num>0&&(num&(num-1))==0&&(num&0x55555555)!=0;
    }
}
