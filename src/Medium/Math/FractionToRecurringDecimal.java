package Medium.Math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by menghan on 2017/6/23.
 */
public class FractionToRecurringDecimal {
    public static void main(String[] args){
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-1,-2147483648));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        long numera=Math.abs((long)numerator);
        long denomi=Math.abs((long)denominator);
        String sb=(numerator>0)^(denominator>0)?"-":"";
        long k=numera/denomi;
        long remain=numera%denomi;
        sb+=k;
        if(remain==0) return sb;
        sb+=".";
        Map<Long,Integer> map=new HashMap<>();
        while(!map.containsKey(remain)&&remain!=0){
            map.put(remain,sb.length());
            sb=sb+(remain*10/denomi);
            remain=(remain*10)%denomi;
        }
        if(remain==0) return sb;
        else{
            int index=map.get(remain);
            return sb.substring(0,index)+"("+sb.substring(index)+")";
        }
    }
}
