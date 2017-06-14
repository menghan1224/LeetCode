package Medium.Array;

/**
 * Created by 28479 on 2017/6/14.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        for(;i>0;i--){
            if(nums[i-1]<nums[i]) break;
        }
        if(i==0) {
            reverse(nums,0,nums.length-1);
            return;
        }
        for(int k= nums.length-1;k>i-1;k--){
            if(nums[k]>nums[i-1]){
                swap(nums,k,i-1);
                reverse(nums,i,nums.length-1);
                return;
            }
        }
    }
    public void reverse(int[] arr,int i,int j){
        while(i<j){
            swap(arr,i++,j--);
        }
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
