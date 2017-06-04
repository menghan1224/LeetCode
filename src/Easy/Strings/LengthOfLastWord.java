package Easy.Strings;

/**
 * Created by menghan on 2017/6/4.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len=s.length()-1;
        int wordLength=0;
        while(len>=0&&s.charAt(len)==' '){
            len--;
        }
        while(len>=0&&s.charAt(len)!=' '){
            len--;
            wordLength++;
        }
        return wordLength;
    }
}
