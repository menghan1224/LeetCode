package Easy;

/**
 * Created by 28479 on 2017/6/2.
 */
public class FisrtUniqueCharacterinAString {
    public int firstUniqChar(String s) {
        int[] res = new int[26];
        for(int i=0;i<s.length();i++){
            res[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(res[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
