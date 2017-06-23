package Medium.Array;

import java.util.TreeSet;

/**
 * Created by menghan on 2017/6/23.
 */
public class ContainDuplicatesIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<1||t<0) return false;
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if((set.ceiling(nums[i])!=null&&set.ceiling(nums[i])<=nums[i]+t)||(set.floor(nums[i])!=null&&set.floor(nums[i])+t<=nums[i]))
                return true;
            set.add(nums[i]);
            if(i>=k) set.remove(nums[i-k]);
        }
        return false;
    }
}
