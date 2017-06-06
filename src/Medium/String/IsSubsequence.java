package Medium.String;

/**
 * Created by 28479 on 2017/6/6.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()) return false;
        if(s.length()==0) return  true;
        int si=0,ti=0;
        for(int i=0;i<t.length();i++){
            if(s.charAt(si)==t.charAt(i)){
                si++;
                if(si==s.length()) return true;
            }
        }
        return false;
    }
}
