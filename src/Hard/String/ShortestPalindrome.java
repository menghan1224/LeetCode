package Hard.String;

/**
 * Created by menghan on 2017/6/30.
 */
public class ShortestPalindrome {
    public static void main(String[] args){
        new ShortestPalindrome().Kmp("aac");
    }
    public String shortestPalindrome(String str){
        return new StringBuilder(str).reverse().substring(0,str.length()-Kmp(str))+str;
    }
    public int Kmp(String str){
        StringBuilder sb=new StringBuilder(str);
        String tmp=sb.toString()+"#"+sb.reverse().toString();
        int[] arr=new int[tmp.length()];
        int j=0;
        for(int i=1;i<arr.length;i++){
            j=arr[i-1];
            while(j!=0&&tmp.charAt(i)!=tmp.charAt(j)) j=arr[j-1];
            arr[i]=j==0?(tmp.charAt(i)==tmp.charAt(j)?1:0):j+1;
        }
        return arr[arr.length-1];
    }
}
