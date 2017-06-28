package DataStructure;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by menghan on 2017/6/28.
 */
public class MedianFinder {
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;
    public MedianFinder() {
        maxHeap=new PriorityQueue<>((a,b)->(b-a));
        minHeap=new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size()) maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        return maxHeap.size()==minHeap.size()?(double)(maxHeap.peek()+minHeap.peek())/2:maxHeap.peek();
    }
}
