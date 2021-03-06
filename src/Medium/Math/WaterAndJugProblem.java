package Medium.Math;

/**
 * Created by 28479 on 2017/6/16.
 */
public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        return z==0||((x+y>=z)&&(z%gcd(x,y)==0));
    }
    public int gcd(int x,int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
