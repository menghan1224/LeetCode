package Exer;

import java.util.Random;

/**
 * Created by menghan on 2017/10/24.
 */
public class ShortestString {
    public static void main(String[] args) {
        System.out.println(solution("nmhbwnmhbwnnmhbnmhbwgmisbnnmhbwgmisbnulyfnmhbwgnmhbwgmisbnulyft"));
    }
    private static String solution(String s) {
        // 在此处理单行数据
        int n = s.length();
        java.util.List<Integer> list = new java.util.ArrayList<Integer>();
        for(int i = 0; i < n; i++)
            if(s.charAt(i) == s.charAt(0))
                list.add(i);
        int m = list.size();
        list.add(n);
        if(m < 2)
            return s;
        String t = s.substring(0, list.get(1));
        int index = 0;
        int len = 1;
        for(int i = 1; i < m; i++) {
            boolean flag = false;
            for(int j = i + 1; j <= m; j++) {
                String tmp = s.substring(list.get(i), list.get(j));
                if(t.equals(tmp)) {
                    index = i;
                    flag = true;
                    break;
                }
                if(t.startsWith(tmp)) {
                    flag = true;
                    break;
                }
                if(tmp.length() > t.length()) {
                    if(tmp.startsWith(t)) {
                        t = tmp;
                        flag = true;
                        len = j - i;
                        index = i;
                    }
                    break;
                }
            }
            if(!flag) {
                for (int j = 1; j <= len + 1 && i - j + 1 >= 0; j++) {
                    String tmp = s.substring(list.get(i - j + 1), list.get(i + 1));
                    if (t.startsWith(tmp)) {
                        flag = true;
                        break;
                    }
                    if (tmp.startsWith(t)) {
                        flag = true;
                        len = j;
                        index = i - j + 1;
                        t = tmp;
                        break;
                    }
                }
            }
            if(!flag) {
                len = i + 1 - index;
                t = s.substring(list.get(index), list.get(i + 1));
            }
        }
        // 返回处理后的结果
        return t;
    }
    public static int[] getNext(String b) {
        int len = b.length();
        int j = 0;

        int next[] = new int[len + 1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
        next[0] = next[1] = 0;

        for (int i = 1; i < len; i++)//i表示字符串的下标，从0开始
        {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
            while (j > 0 && b.charAt(i) != b.charAt(j)) j = next[j];
            if (b.charAt(i) == b.charAt(j)) j++;
            next[i + 1] = j;
        }

        return next;
    }

}
