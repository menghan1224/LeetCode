package Easy.Strings;

/**
 * Created by 28479 on 2017/6/1.
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] arr=s.toCharArray();
        int len=arr.length;
        for(int i=0;i<len/2;i++){
            char temp=arr[i];
            arr[i]=arr[len-i-1];
            arr[len-1-i]=temp;
        }
        return String.valueOf(arr);
    }
}
