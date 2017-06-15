package Medium.String;

/**
 * Created by 28479 on 2017/6/14.
 */
public class AdditiveNumber {
    public static void main(String[] rags){
        new AdditiveNumber().isAdditiveNumber("112358");
    }
    public boolean isAdditiveNumber(String num) {
        int len=num.length();
        for(int i=1;i<=len/2;i++){
            for(int j=1;Math.max(i,j)<=len-i-j;j++){
                if(isAdd(num,i,j)) return true;
            }
        }
        return false;
    }
    public boolean isAdd(String num,int i,int j){
        if(num.charAt(0)=='0'&&i>1) return  false;
        if(num.charAt(i)=='0'&&j>1) return  false;
        Long n1=Long.parseLong(num.substring(0,i));
        Long n2=Long.parseLong(num.substring(i,i+j));
        String sum="";
        for(int k=i+j;k<num.length();k+=sum.length()){
            n2=n1+n2;
            n1=n2-n1;
            sum=n2.toString();
            if(!num.startsWith(sum,k)) return false;
        }
        return true;
    }
}
