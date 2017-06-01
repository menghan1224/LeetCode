import java.util.HashMap;

/**
 * Created by 28479 on 2017/6/1.
 */
public class TwoSUm {
    public static void main(String[] args){


    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
          if(map.get(target-nums[i])!=null){
              res[0]=i;
              res[1]=map.get(target-nums[i]);
              break;
          }
          else{
              map.put(nums[i],i);
          }
        }

        return res;
    }
}
