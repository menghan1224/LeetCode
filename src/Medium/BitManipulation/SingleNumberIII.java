package Medium.BitManipulation;

/**
 * Created by 28479 on 2017/6/6.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int res[]=new int[2];
        int diff=0;
        for(int num:nums)
            diff^=num;
        diff&=-diff;
        for(int num:nums){
            if((diff&num)==0)
                res[0]^=num;
            else res[1]^=num;
        }
        return res;
    }
}
