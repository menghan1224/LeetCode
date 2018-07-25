package Exer;

import java.util.HashMap;

/**
 * Created by menghan on 2017/10/18.
 */
public class SameStructure {
    public static void main(String[] args) {
        System.out.println(solution("edd,abb"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(",");
        char[] a1 = strs[0].toCharArray();
        char[] a2 = strs[1].toCharArray();
        if(a1.length!=a2.length) return "0";
        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0;i<a1.length;i++){
            if(map.get(a1[i])==null){
                map.put(a1[i],a2[i]);
            }else{
                if(map.get(a1[i])!=a2[i]) return "0";
            }
        }
        map.clear();
        for(int i=0;i<a1.length;i++){
            if(map.get(a2[i])==null){
                map.put(a2[i],a1[i]);
            }else{
                if(map.get(a2[i])!=a1[i]) return "0";
            }
        }
        // 返回处理后的结果
        return "1";
    }
}
