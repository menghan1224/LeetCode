package Easy;

/**
 * Created by menghan on 2017/6/2.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len=nums.length;
        int res=0;
        for(int i=0;i<len;i++){
            res^=i;
            res^=nums[i];
        }
        res^=len;
        return res;
    }
}
