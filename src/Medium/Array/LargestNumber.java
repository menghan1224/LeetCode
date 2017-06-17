package Medium.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by 28479 on 2017/6/17.
 */
public class LargestNumber {
    public static void main(String[] args){
       String str = new LargestNumber().largestNumber(new int[]{3,30,34,5,9});
       System.out.println(str);
    }
    public String largestNumber(int[] nums) {
        if(nums.length<1) return "";
        String[] s=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            s[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                return s2.compareTo(s1);
            }
        });
        if(s[0].charAt(0)=='0') return "0";
        StringBuilder sb=new StringBuilder();
        for(String str:s){
            sb.append(str);
        }
        return sb.toString();
    }
}
