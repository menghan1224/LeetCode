package Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/14.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        if(nums.length==0) return res;
        int start=nums[0];
        int end=start;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>start+1){
                if(end>start) res.add(new String(start+"->"+end));
                else res.add(new String(start+""));
                start=nums[i];
                end=nums[i];
            }else{
                end++;
            }
        }
        if(end>start) res.add(new String(start+"->"+end));
        else res.add(new String(start+""));
        return res;
    }
}
