package Medium.Array;

/**
 * Created by 28479 on 2017/6/7.
 */
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        int kthMin=nums.length-k;
        int begin=0,end=nums.length-1;
        while(begin<=end){
            int index=quickSort(nums,begin,end);
            if(index==kthMin) return nums[index];
            else if(index<kthMin){
                begin=index+1;
                kthMin-=index;
            }
            else{
                end=index-1;
            }
        }
        return nums[begin];
    }
    public int quickSort(int[] arr,int begin,int end){
        int tmp=arr[begin];
        int index=begin;
        for(int i=begin+1;i<=end;i++){
            if(arr[i]<tmp){
                swap(arr,++index,i);
            }
        }
        swap(arr,index,begin);
        return index;
    }
    public void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
