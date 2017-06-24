package Hard.Array;

import java.util.LinkedList;

/**
 * Created by menghan on 2017/6/24.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0) return new int[0];
        int[] res=new int[nums.length-k+1];
        int index=0;
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!list.isEmpty()&&nums[i]>=nums[list.getLast()]) list.removeLast();
            list.addLast(i);
            if(i-list.getFirst()+1>k) list.removeFirst();
            if(i+1>=k) res[index++]=nums[list.getFirst()];
        }
        return res;
    }
}
