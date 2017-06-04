package Easy.Maths;

/**
 * Created by 28479 on 2017/6/3.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0||(x!=0&&x%10==0)) return false;
        int rev=0;
        while(rev<x){
            rev=rev*10+x%10;
            x/=10;
        }
        return rev==x||x==rev/10;
    }
}
