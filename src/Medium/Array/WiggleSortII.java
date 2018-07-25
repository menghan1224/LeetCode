package Medium.Array;

/**
 * Created by menghan on 2017/6/16.
 */
public class WiggleSortII {
    public static void main(String[] args){
        int a[]=new int[]{6,13,5,4,5,2};
        new WiggleSortII().wiggleSort(a);
        for(int num:a)
            System.out.println(num);
    }
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;
        for(int num:nums) System.out.println(num);
        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }
    public int findKthLargest(int[] nums, int k) {
        int kthMin=nums.length-k;
        int begin=0,end=nums.length-1;
        while(begin<=end){
            int index=quickSort(nums,begin,end);
            if(index==kthMin) return nums[index];
            else if(index<kthMin){
                begin=index+1;

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
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
}
