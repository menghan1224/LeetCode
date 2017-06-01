import java.util.HashSet;
import java.util.Set;

/**
 * Created by 28479 on 2017/6/1.
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet();
        HashSet<Integer> resSet = new HashSet();
        for(int num:nums1)
            set1.add(num);
        for(int num:nums2){
            if(set1.contains(num))
                resSet.add(num);
        }
        int[] res=new int[resSet.size()];
        int i=0;
        for(Integer num:resSet){
            res[i++]=num;
        }
        return res;
    }
}
