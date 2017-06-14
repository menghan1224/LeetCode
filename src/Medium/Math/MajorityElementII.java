package Medium.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/14.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int a=0,b=0,ca=0,cb=0;
        for(int num:nums){
            if(num==a) ca++;
            else if(num==b) cb++;
            else if(ca==0){
                a=num;
                ca=1;
            }else if(cb==0){
                b=num;
                cb++;
            }else{
                ca--;
                cb--;
            }
        }
        ca=0;
        cb=0;
        for(int num:nums){
            if(a==num) ca++;
            if(b==num) cb++;
        }
        List<Integer> list=new ArrayList<>();
        if(ca>nums.length/3) list.add(a);
        if(cb>nums.length/3) list.add(b);
        return list;
    }
}
