package Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by menghan on 2017/6/13.
 */
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]>list=new ArrayList<>();
        k=Math.min(k, nums1.length*nums2.length);
        int tmp[]=new int[nums1.length];
        while(k-->0){
            int min=Integer.MAX_VALUE;
            int temp=0;
            for(int i=0;i<nums1.length;i++){
                if(tmp[i]<nums2.length&&nums1[i]+nums2[tmp[i]]<min){
                    min=nums1[i]+nums2[tmp[i]];
                    temp=i;
                }
            }
            list.add(new int[]{nums1[temp],nums2[tmp[temp++]]});
        }
        return list;
    }
}
