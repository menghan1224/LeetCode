package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by menghan on 2017/6/4.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<Character,Character>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==null) map.put(s.charAt(i),t.charAt(i));
            else{
                if(map.get(s.charAt(i))!=t.charAt(i)) return false;
            }
        }
        map.clear();
        for(int i=0;i<s.length();i++){
            if(map.get(t.charAt(i))==null) map.put(t.charAt(i),s.charAt(i));
            else{
                if(map.get(t.charAt(i))!=s.charAt(i)) return false;
            }
        }
        return true;
    }
}
