package Exer;

/**
 * Created by menghan on 2017/7/3.
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args){
        int[] a=new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1,2,3,4});
        for(int num:a) System.out.println(num);
    }
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int [nums.length];
        res[0]=1;
        for(int i=1;i<nums.length;i++) {
            res[i]=nums[i-1]*res[i-1];
        }
        int right=1;
        for(int j=nums.length-1;j>=0;j--){
            res[j]*=right;
            right*=nums[j];
        }
        return res;
    }
}
