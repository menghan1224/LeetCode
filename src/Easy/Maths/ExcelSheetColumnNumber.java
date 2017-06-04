package Easy.Maths;

/**
 * Created by 28479 on 2017/6/2.
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args){
        new ExcelSheetColumnNumber().titleToNumber("A");
    }
    public int titleToNumber(String s) {
        int len=s.length();
        int res=0;
        for(int i=0;i<s.length();i++){
            res+=(s.charAt(i)-'A'+1)*(Math.pow(26,len-i-1));

        }
        return res;
    }
}
