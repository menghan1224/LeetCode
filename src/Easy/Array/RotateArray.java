package Easy.Array;

/**
 * Created by 28479 on 2017/6/4.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {

        int len=nums.length;
        if(k>=len) k=k%len;
        reverse(nums,0,len-k-1);
        reverse(nums,len-k,len-1);
        reverse(nums,0,len-1);
    }
    public void reverse(int[] a,int i,int j)
    {
        int temp;
        for(;i<j;i++,j--){
            temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
    }
}
