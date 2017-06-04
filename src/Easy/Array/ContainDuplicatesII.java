package Easy.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by menghan on 2017/6/4.
 */
public class ContainDuplicatesII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.get(nums[i])==null)
                map.put(nums[i],i);
            else
            {
                if(i-map.get(nums[i])<=k)
                    return true;
                else
                    map.put(nums[i],i);
            }
        }
        return false;
    }
}
