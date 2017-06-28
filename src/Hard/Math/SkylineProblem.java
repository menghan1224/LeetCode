package Hard.Math;

import java.util.*;

/**
 * Created by menghan on 2017/6/28.
 */
public class SkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        ArrayList<int[]> list = new ArrayList<>();
        List<int[]> tmp=new ArrayList<>();
        for(int[] building:buildings){
            tmp.add(new int[]{building[0],-building[2]});
            tmp.add(new int[]{building[1],building[2]});
        }
        Collections.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]) return o1[0]-o2[0];
                else return o1[1]-o2[1];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.offer(0);
        int pre=0;
        for(int[] arr:tmp){
            if(arr[1]<0) queue.offer(-arr[1]);
            else queue.remove(arr[1]);
            Integer peek=queue.peek();
            if(peek!=pre){
                list.add(new int[]{arr[0],peek});
                pre=peek;
            }
        }
        return list;
    }
}
