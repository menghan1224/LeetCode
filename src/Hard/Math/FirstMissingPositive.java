package Hard.Math;

/**
 * Created by menghan on 2017/6/29.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0||nums[i]==i+1||nums[i]>nums.length) continue;
            else if(nums[nums[i]-1]!=nums[i]){
                swap(nums,nums[i]-1,i);
                i--;
            }
        }
        int i=0;
        while(i<nums.length&&nums[i]==i+1) i++;
        return i+1;
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
