package Easy.Maths;

/**
 * Created by menghan on 2017/6/2.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        for(int i=2;i<6&&num>0;i++){
            while(num%i==0)
                num%=i;
        }
        return num==1;
    }
}
