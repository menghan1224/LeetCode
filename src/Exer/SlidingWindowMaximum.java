package Exer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by menghan on 2017/7/3.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k<=0||k>nums.length) return new int[0];
        int[] res=new int[nums.length-k+1];
        Deque<Integer> queue=new LinkedList<>();
        int index=0;
        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty()&&nums[i]>=nums[queue.getLast()]) queue.removeLast();
            queue.addLast(i);
            if(i-queue.getFirst()>=k) queue.removeFirst();
            if(i+1>=k) res[index++]=nums[queue.getFirst()];
        }
        return res;
    }
}
