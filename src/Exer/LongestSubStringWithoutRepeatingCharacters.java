package Exer;

import java.util.Arrays;

/**
 * Created by menghan on 2017/7/4.
 */
public class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int index=-1;
        int words[]=new int[128];
        for(int i=0;i<words.length;i++)
            words[i]=-1;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(words[s.charAt(i)]>index){
                index=words[s.charAt(i)];
            }
            if(i-index>max) max=i-index;
            words[s.charAt(i)]=i;
        }
        return max;
    }
}
