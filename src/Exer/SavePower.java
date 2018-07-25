package Exer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by menghan on 2017/10/18.
 */
public class SavePower {
    public static void main(String[] args) {
        System.out.println(solution("101010101"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        char[] arr = new char[line.length()+1];
        for(int i=1;i<arr.length;i++){
            arr[i]=line.charAt(i-1);
        }
        arr[0]='0';
        Set<String> set = new HashSet<>();
        Queue<char[]> queue = new LinkedList<>();
        // 返回处理后的结果
        queue.add(arr);
        int parSize = 1;
        int childSize =0;
        int depth=0;
        while(!queue.isEmpty()){
            char[] tmp = queue.poll();
            parSize--;
            if (check(tmp)){
                return depth+"";
            }
            for(int i=1;i<arr.length;i++){
                char[] ttmp = Arrays.copyOf(tmp,tmp.length);
                for(int j=i;j<arr.length;j+=i){
                    if(ttmp[j]=='1') ttmp[j]='0';
                    else ttmp[j]='1';
                }
                String res = new String(ttmp);
                if(set.contains(res)) continue;
                set.add(res);
                queue.add(ttmp);
                childSize++;
            }
            if(parSize==0){
                parSize=childSize;
                childSize=0;
                depth++;
            }
        }
        return "-1";
    }
    public static boolean check(char[] arr){
        for(int i=1;i<arr.length;i++) if(arr[i]!='0') return false;
        return true;
    }
}
