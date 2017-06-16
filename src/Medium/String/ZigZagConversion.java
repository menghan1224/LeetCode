package Medium.String;

/**
 * Created by 28479 on 2017/6/16.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int length=s.length();
        char[] res=new char[length];
        int mark=2*numRows-2;
        int temp=0;
        for(int i=0;i<numRows&&i<length;i++)
        {
            int index=mark-i;
            for(int j=i;j<length;j+=2*numRows-2)
            {
                res[temp++]=s.charAt(j);
                if(i>0&&i<numRows-1){
                    if(index<length) {
                        res[temp++] = s.charAt(index);
                        index += mark;
                    }
                }
            }
        }
        return new String(res);
    }
}
