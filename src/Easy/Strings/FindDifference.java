package Easy.Strings;

/**
 * Created by 28479 on 2017/6/1.
 */
public class FindDifference {
    public static void main(String[] args){
        System.out.println(new FindDifference().findTheDifference("abc","bacd"));
    }
    public char findTheDifference(String s, String t) {
        int len=t.length();
        char c=t.charAt(len-1);
        for(int i=0;i<len-1;i++){
            c^=s.charAt(i);
            c^=t.charAt(i);
        }
        return c;
    }
}
