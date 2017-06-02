package Easy;

/**
 * Created by menghan on 2017/6/2.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res=nums[0];
        int keyNums=1;
        for(int i=1;i<nums.length;i++){
            if(keyNums==0){
                keyNums++;
                res=nums[i];
            }else if(nums[i]==res){
                keyNums++;
            }else{
                keyNums--;
            }
        }
        return res;
    }
}
