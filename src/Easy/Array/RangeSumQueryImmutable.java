package Easy.Array;

/**
 * Created by menghan on 2017/6/4.
 */
public class RangeSumQueryImmutable {
    public class NumArray {
        int[] tmpArray;
        public NumArray(int[] nums) {
            tmpArray=new int[nums.length+1];
            for(int i=1;i<=nums.length;i++){
                tmpArray[i]=nums[i-1]+tmpArray[i-1];
            }
        }

        public int sumRange(int i, int j) {
            return tmpArray[j+1]-tmpArray[i];
        }
    }
}
