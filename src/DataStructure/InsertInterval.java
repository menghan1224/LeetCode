package DataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by menghan on 2017/6/28.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list=new ArrayList<>();
        int i=0;
        while(i<intervals.size()&&intervals.get(i).end<newInterval.start){
            list.add(intervals.get(i++));
        }
        while(i<intervals.size()&&newInterval.end>=intervals.get(i).start){
            newInterval=new Interval(Math.min(intervals.get(i).start,newInterval.start),Math.max(newInterval.end,intervals.get(i).end));
            i++;
        }
        list.add(newInterval);
        while(i<intervals.size()) list.add(intervals.get(i++));
        return list;
    }
}
