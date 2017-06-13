package Medium.Array;

import java.util.Arrays;

/**
 * Created by menghan on 2017/6/12.
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int begin=0;
        int end=nums.length-1;
        int[] res=new int[2];
        Arrays.fill(res,-1);
        while(begin<=end){
            int mid=(begin+end)/2;
            if(nums[mid]==target){
                int low=mid,high=mid;
                while(nums[low-1]==target) low--;
                while(nums[high+1]==target) high++;
                res[0]=low;
                res[1]=high;
                return res;
            }
            else if(nums[mid]<target){
                begin=mid+1;
            }else end=mid-1;
        }

        return res;
    }
}
