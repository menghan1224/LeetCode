package Easy.Array;

import java.util.HashSet;

/**
 * Created by menghan on 2017/6/2.
 */
public class ContainDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num:nums){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
