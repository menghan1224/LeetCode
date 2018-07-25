package Exer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by menghan on 2017/10/24.
 */
public class GCRoots {
    public static void main(String[] args) {
        System.out.println(solution("5 5;0 1,1 2,2 3,3 4,2 1"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(";");
        String[] mn = strs[0].split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String[] nodes = strs[1].split(",");
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(String node:nodes){
            String[] relation = node.split(" ");
            int n1 = Integer.parseInt(relation[0]);
            int n2 = Integer.parseInt(relation[1]);
            if(map.get(n2)==null){
                Set<Integer> set = new HashSet<>();
                set.add(n1);
                map.put(n2,set);
            }
            else map.get(n2).add(n1);
        }
        int count = 0;
        for(int i = m-1;i>0;i--){
            if(!check(map,i,new boolean[m])) count++;
        }
        // 返回处理后的结果
        return count+"";
    }
    private static boolean check(Map<Integer,Set<Integer>> map,int val,boolean[] cache){
        if(val==0) return true;
        if(map.get(val)==null) return false;
        if(cache[val]) return false;
        cache[val] = true;
        for(int tmp:map.get(val)){
            if(check(map,tmp,cache)) return true;
        }
        return false;
    }
}
