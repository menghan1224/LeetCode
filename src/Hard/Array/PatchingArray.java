package Hard.Array;

/**
 * Created by menghan on 2017/6/24.
 */
public class PatchingArray {
    public static void main(String[] args){
        System.out.println(new PatchingArray().minPatches(new int[]{5,10,15},30));
    }
    public int minPatches(int[] nums, int n) {
        long miss=1;
        int i=0;
        int res=0;
        while(miss<=n){
            if(i<nums.length&&miss>=nums[i]){
                miss+=nums[i++];
            }
            else{
                miss+=miss;
                res++;
            }
        }
        return res;
    }
}
