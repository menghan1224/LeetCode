package Exer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by menghan on 2017/10/17.
 */
public class Poke {
    public static void main(String[] args) {
        System.out.println(solution("M;M;D7;S6;M"));
    }
    static boolean tonghua = false;
    static boolean shunzi = false;
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(";");
        int countMR=0;
        int[] res = new int[14];
        Set<Character> set = new HashSet<>();
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals("M")) countMR++;
            else{
                char color = strs[i].charAt(0);
                set.add(color);
                if(strs[i].substring(1).equals("A")) res[1]++;
                else if(strs[i].substring(1).equals("J")) res[11]++;
                else if(strs[i].substring(1).equals("Q")) res[12]++;
                else if(strs[i].substring(1).equals("K")) res[13]++;
                else {
                    res[Integer.parseInt(strs[i].substring(1))]++;
                }
            }
        }
        if(set.size()>1) {
            tonghua=false;
        }else tonghua=true;
        int i=1;
        while(i<res.length&&res[i]==0){
            i++;
        }
        if(i==res.length) return "Straight Flush";
        int count=0;
        int countM = countMR;
        for(int index=i;index<14;index++){
            if(res[index]>1) {
                shunzi=false;
                break;
            }
            else if(res[index]==1) count++;
            else{
                if(countM-->0) count++;
                else {
                    shunzi=false;
                    break;
                }
            }
        }
        if(count==5) shunzi=true;
        if(!shunzi) {
            count = 0;
            countM = countMR;
            for (int index = i; index >= 0; index--) {
                if (res[index] > 1) {
                    shunzi = false;
                    break;
                }
                if (res[index] == 1) count++;
                else {
                    if (countM-- > 0) count++;
                    else {
                        shunzi = false;
                        break;
                    }
                }
            }
            if (count == 5) shunzi = true;
        }
        // 返回处理后的结果
        return tonghua==true?(shunzi==true?"Straight Flush":"Flush"):(shunzi==true?"Straight":"GG");
    }
}
