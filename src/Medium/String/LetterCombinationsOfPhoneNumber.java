package Medium.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 28479 on 2017/6/8.
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        char[] arr=digits.toCharArray();
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        List<String> list=new ArrayList<String>();
        if(digits.length()==0) return list;
        getList(list,"",map,arr,0);
        return list;
    }
    public void getList(List<String>list, String str, Map<Character, char[]>map,char[] arr,int begin){
        if(begin==arr.length) list.add(str);
        char[] subarr=map.get(arr[begin]);
        for(char ch:subarr){
                getList(list,str+ch,map,arr,begin+1);
         }
        return;
    }
}
