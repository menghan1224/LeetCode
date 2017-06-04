package Easy.Maths;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by menghan on 2017/6/2.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res=0;
        char[] roman=s.toCharArray();
        int i;
        for(i=0;i<roman.length-1;i++)
        {
            if(map.get(roman[i])<map.get(roman[i+1]))
            {
                res-=map.get(roman[i]);
            }
            else
            {
                res+=map.get(roman[i]);
            }
        }
        res+=map.get(roman[i]);
        return res;
    }

}
