package Medium.String;

/**
 * Created by 28479 on 2017/6/16.
 */
public class MultiplyStrings {
    public static void main(String[] args){
        System.out.println(new MultiplyStrings().multiply("123","456"));
    }
    public String multiply(String num1, String num2) {
        int[] res=new int[num1.length()+num2.length()];
        String big=num1.length()>num2.length()?num1:num2;
        String small=num1.length()>num2.length()?num2:num1;
        int begin=0;
        int carry=0;
        int len=res.length;
        int temp=1;
        for(int i=small.length()-1;i>=0;i--){
            begin=len-temp;
            carry=0;
            int m2=small.charAt(i)-'0';
            for(int j=big.length()-1;j>=0;j--){
                int m1=big.charAt(j)-'0';
                int sum=m1*m2+carry;
                res[begin--]+=(sum)%10;
                carry=(sum)/10;
            }
            if(carry!=0) res[begin--]+=carry;
            temp++;
        }
        StringBuilder sb=new StringBuilder();
        carry=0;
        for(int i=res.length-1;i>=0;i--){
            temp=res[i];
            res[i]=(res[i]+carry)%10;
            carry=(temp+carry)/10;
        }
        int i=0;
        while(i<res.length&&res[i]==0)
            i++;
        if(i==res.length) return "0";
        for(;i<res.length;i++)
            sb.append(res[i]);
        return sb.toString();
    }
}
