package Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 28479 on 2017/6/8.
 */
public class SubSetsII {
    public static void main(String[] args){
        new SubSetsII().subsetsWithDup(new int[]{1,2,2,});
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDupHelper(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void subsetsWithDupHelper(int[] nums, int pos, List<List<Integer>> res, List<Integer> tmpRes) {
        // subset means it does not need contain all elements, so the condition is <= rather than ==
        // and do not return after this statement
        if(pos <= nums.length) res.add(new ArrayList<>(tmpRes));

        for(int i=pos; i<nums.length; i++) {
            if(i > pos && nums[i] == nums[i-1]) continue;   // avoid duplicates
            tmpRes.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}
