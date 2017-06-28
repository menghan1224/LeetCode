package Hard.String;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Created by menghan on 2017/6/28.
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list=new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++) map.put(words[i],i);
        for(int i=0;i<words.length;i++){
            for(int j=0;j<=words[i].length();j++){
                String str1=words[i].substring(0,j);
                String str2=words[i].substring(j);
                if(isPalindrome(str1)){
                    String str2rev=new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rev)&&map.get(str2rev)!=i){
                        list.add(Arrays.asList(map.get(str2rev),i));
                    }
                }
                if(isPalindrome(str2)){
                    String str1rev=new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1rev)&&map.get(str1rev)!=i&&str2.length()!=0){
                        list.add(Arrays.asList(i,map.get(str1rev)));
                    }
                }
            }
        }
        return list;
    }
    public boolean isPalindrome(String s){
        int i=0;int j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }

}
