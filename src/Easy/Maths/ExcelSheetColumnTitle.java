package Easy.Maths;

/**
 * Created by menghan on 2017/6/4.
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args){
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(28));
    }
    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        while(n!=0){
            sb.append((char)((n-1)%26+'A'));
            n/=26;
        }
        return sb.reverse().toString();
    }
}
