package Medium.BitManipulation;

/**
 * Created by 28479 on 2017/6/6.
 */
public class SingleNumber2 {
    public static void main(String[] args){
        new SingleNumber2().singleNumber(new int[]{2,3,2,2});
    }
    public int singleNumber(int[] nums) {
        int k=32;
        int res=0;
        for(int i=0;i<k;i++){
            int tmp=1<<i;
            int count=0;
            for(int num:nums){
                if((num&tmp)==tmp) count++;
            }
            if(count%3!=0) res|=tmp;
        }
        return res;
    }
}
