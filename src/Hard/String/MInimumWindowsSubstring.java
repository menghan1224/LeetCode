package Hard.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by menghan on 2017/6/29.
 */
public class MInimumWindowsSubstring {
    public String minWindow(String s, String t) {
        if(s.length()==0||s.length()<t.length()) return "";
        Map<Character,Integer> map=new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,(map.get(c)==null?0:map.get(c))+1);
        }
        int begin=0,end=0,minbegin=0;
        int minLen=s.length()+1;
        int count=0;
        for(;end<s.length();end++){
            char c=s.charAt(end);
            if(map.containsKey(c)){
                Integer i=map.get(c);
                map.put(c,i-1);
                if(--i>=0) count++;
                while(count==t.length()){
                    if(end-begin+1<minLen) {
                        minLen=end-begin+1;
                        minbegin=begin;
                    }
                    if(map.containsKey(s.charAt(begin))){
                        Integer tmp=map.get(s.charAt(begin));
                        map.put(s.charAt(begin),tmp+1);
                        if(tmp>=0) count--;
                    }
                    begin++;
                }
            }
        }
        if(minLen==s.length()+1) return "";
        return s.substring(minbegin,minbegin+minLen);
    }
}
