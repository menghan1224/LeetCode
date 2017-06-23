package DataStructure;

import DataStructure.Interval;

import java.util.*;

/**
 * Created by 28479 on 2017/6/14.
 */
public class SummaryRanges {
    TreeMap<Integer,Interval> tree;
    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val)) return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if(l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } else if(l != null && tree.get(l).end + 1 >= val) {
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } else if(h != null && h == val + 1) {
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } else {
            tree.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
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
