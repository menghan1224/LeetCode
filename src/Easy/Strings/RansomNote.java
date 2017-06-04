package Easy.Strings;

/**
 * Created by 28479 on 2017/6/2.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] tmp=new int[26];
        for(int i=0;i<magazine.length();i++){
            tmp[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(--tmp[ransomNote.charAt(i)-'a']<0) return false;
        }
        return true;
    }
}
