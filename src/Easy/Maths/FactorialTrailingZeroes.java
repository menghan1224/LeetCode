package Easy.Maths;

/**
 * Created by 28479 on 2017/6/3.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        return n==0?0:n/5+trailingZeroes(n/5);
    }
    public static void main(String[] args){
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(10));
    }
}
