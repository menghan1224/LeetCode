package Medium.Array;

import DataStructure.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 28479 on 2017/6/14.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        List<Interval> res=new ArrayList<>();
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start>end){
                res.add(new Interval(start,end));
                start=intervals.get(i).start;
                end=intervals.get(i).end;
            }
            else{
                end=Math.max(intervals.get(i).end,end);
            }
        }
        res.add(new Interval(start,end));
        return res;
    }
}
