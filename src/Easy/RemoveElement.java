package Easy;

/**
 * Created by menghan on 2017/6/2.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index=0;
        for(int num:nums){
            if(num!=val) nums[index++]=num;
        }
        return index;
    }
}
