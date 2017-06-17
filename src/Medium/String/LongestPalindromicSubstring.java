package Medium.String;

/**
 * Created by 28479 on 2017/6/16.
 */
public class LongestPalindromicSubstring {
    int low,maxLen;
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        for(int i=0;i<s.length();i++){
            getString(s,i,i);
            getString(s,i,i+1);
        }
        return s.substring(low,low+maxLen);
    }
    public void getString(String s,int i,int j){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(maxLen<j-i-1){
            low=i+1;
            maxLen=j-i-1;
        }
    }
}
