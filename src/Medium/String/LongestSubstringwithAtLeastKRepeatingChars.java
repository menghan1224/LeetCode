package Medium.String;

/**
 * Created by 28479 on 2017/6/8.
 */
public class LongestSubstringwithAtLeastKRepeatingChars {
    public int longestSubstring(String s, int k) {
        char[] arr=s.toCharArray();
        return getMax(arr,0,arr.length-1,k);
    }
    public int getMax(char[] arr,int begin,int end,int k){
        if(end-begin+1<k) return 0;
        int[] tmp=new int[26];
        for(int i=begin;i<=end;i++) tmp[arr[i]-'a']++;
        for(int i=0;i<26;i++){
            if(tmp[i]<k){
                char cha=(char)('a'+i);
                for(int j=begin;j<=end;j++){
                    if(arr[j]==cha){
                        int len=Math.max(getMax(arr,begin,j-1,k),getMax(arr,j+1,end,k));
                        return len;
                    }
                }
            }
        }
        return end-begin+1;
    }
}
