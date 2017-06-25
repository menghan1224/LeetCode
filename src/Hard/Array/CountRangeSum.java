package Hard.Array;

/**
 * Created by menghan on 2017/6/25.
 */
public class CountRangeSum {
    public static void main(String[] args){
        System.out.println(new CountRangeSum().countRangeSum(new int[]{-2,5,-1},-2,2));
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length==0) return 0;
        long[] sum=new long[nums.length+1];
        for(int i=0;i<nums.length;i++){
            sum[i+1]=nums[i]+sum[i];
        }
        return mergeCount(sum,lower,upper,0,nums.length);
    }
    public int mergeCount(long[] sums,int lower,int upper,int begin,int end){
        if(begin>=end) return 0;
        int mid=(begin+end)/2;
        int count=mergeCount(sums,lower,upper,begin,mid)+mergeCount(sums,lower,upper,mid+1,end);
        long[] cache=new long[end-begin+1];
        int k=mid+1;int j=mid+1;int cacheIndex=0;int index=mid+1;
        for(int i=begin;i<=mid;i++,cacheIndex++){
            while(j<=end&&sums[j]-sums[i]<lower) j++;
            while(k<=end&&sums[k]-sums[i]<=upper) k++;
            count+=k-j;
            while(index<=end&&sums[i]>=sums[index]) cache[cacheIndex++]=sums[index++];
            cache[cacheIndex]=sums[i];
        }
        System.arraycopy(cache,0,sums,begin,index-begin);
        return count;
    }

}
