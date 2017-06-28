package Hard.Array;

import java.util.Arrays;

/**
 * Created by menghan on 2017/6/27.
 */
public class MaximumGap {
    public static void main(String[] args){
        System.out.println(new MaximumGap().maximumGap(new int[]{0,7,8,12}));
    }
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            min=Math.min(num,min);
            max=Math.max(num,max);
        }
        int gap=(int)Math.ceil((double)(max-min)/(nums.length-1));
        int[] arrmin=new int[nums.length-1];
        int[] arrmax=new int[nums.length-1];
        Arrays.fill(arrmin,Integer.MAX_VALUE);
        Arrays.fill(arrmax,Integer.MIN_VALUE);
        for(int num:nums){
            if(num==max||num==min) continue;
            int index=(num-min)/gap;
            arrmax[index]=Math.max(arrmax[index],num);
            arrmin[index]=Math.min(arrmin[index],num);
        }
        int maxGap=0;
        int temp=min;
        for(int i=0;i<arrmax.length;i++){
            if(arrmax[i]==Integer.MIN_VALUE&&arrmin[i]==Integer.MAX_VALUE) continue;
            maxGap=Math.max(maxGap,arrmin[i]-temp);
            temp=arrmax[i];
        }
        maxGap=Math.max(maxGap,max-temp);
        return maxGap;
    }
}
