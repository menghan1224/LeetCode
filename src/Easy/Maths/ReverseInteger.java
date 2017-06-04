package Easy.Maths;

/**
 * Created by 28479 on 2017/6/4.
 */
public class ReverseInteger {
    public static void main(String[] args){
       new ReverseInteger().reverse(1534236469);
    }
    public int reverse(int x) {
        long res=0;
        while(x!=0){
            res=res*10+x%10;
            //if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE) return 0;
            x=x/10;
        }
        return (int)res;
    }
}
