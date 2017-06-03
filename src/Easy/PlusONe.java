package Easy;

/**
 * Created by 28479 on 2017/6/3.
 */
public class PlusONe {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] newDidgits=new int[digits.length+1];
        newDidgits[0]=1;
        return newDidgits;
    }
}
