package Exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by menghan on 2017/9/30.
 */
public class test {
    public static void main(String[] args) {
        System.out.println(solution("511,161"));
    }
    private static String solution(String line) {
        String strs[] = line.split(",");
        int[] res = new int[strs.length];
        for(int i=0;i<res.length;i++){
            res[i]=Integer.parseInt(strs[i]);
        }
        Arrays.sort(res);
        int i=0;
        StringBuilder sb = new StringBuilder();
        for(;i<res.length-1;i++) sb.append(res[i]+",");
        sb.append(res[i]+";");
        while(nextPermutation(res)){
            i=0;
            for(;i<res.length-1;i++) sb.append(res[i]+",");
            sb.append(res[i]+";");
        }
        return sb.substring(0,sb.length()-1);
    }
    public static boolean nextPermutation(int[] num) {
        int pos = -1;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] > num[i - 1]) {
                pos = i - 1;
                break;
            }
        }
        if (pos < 0) {
            return false;
        }
        for (int i = num.length - 1; i > pos; i--) {
            if (num[i] > num[pos]) {
                int tmp = num[i];
                num[i] = num[pos];
                num[pos] = tmp;
                break;
            }
        }
        reverse(num, pos + 1, num.length - 1);
        return  true;
    }
    public static void reverse(int[] num, int begin, int end) {
        int l = begin, r = end;
        while (l < r) {
            int tmp = num[l];
            num[l] = num[r];
            num[r] = tmp;
            l++;
            r--;
        }
    }






}
