package Easy;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by menghan on 2017/6/4.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map=new HashMap<Character,String>();
        Map<String,Character> map2=new HashMap<String,Character>();
        String[] strs=str.split(" ");
        if(pattern.length()!=strs.length) return false;
        for(int i=0;i<pattern.length();i++){
            if(map.get(pattern.charAt(i))==null){
                if(map2.get(strs[i])==null){
                    map.put(pattern.charAt(i),strs[i]);
                    map2.put(strs[i],pattern.charAt(i));
                }
                else return false;
            }
            else{
                if(!map.get(pattern.charAt(i)).equals(strs[i])) return false;
                if(map2.get(strs[i])!=pattern.charAt(i)) return false;
            }
        }
        return true;
    }
}
