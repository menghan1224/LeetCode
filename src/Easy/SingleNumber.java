package Easy;

/**
 * Created by 28479 on 2017/6/1.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int num:nums){
            res^=num;
        }
        return res;
    }
}
