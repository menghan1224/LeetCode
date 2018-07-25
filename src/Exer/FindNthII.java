package Exer;

import java.util.Map;

/**
 * Created by menghan on 2017/10/19.
 */
public class FindNthII {
    public static void main(String[] args) {
        System.out.println(solution("7"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        long k = Long.parseLong(line);
        long begin=1;
        long i=1;
        for(;i<Integer.MAX_VALUE;i++){
            long numbers = (long)(Math.pow(10,i)- Math.pow(10,i-1));
            long sum = numbers*begin+numbers*(numbers-1)*i/2;
            if(sum>=k) break;
            k-=sum;
            begin+=(numbers-1)*i+(i+1);
        }
        long m = begin;
        for(;m<Long.MAX_VALUE;m+=i){
            if(k>m) k-=m;
            else break;
        }
        int result = findNthDigit(k);
        // 返回处理后的结果
        return result+"";
    }
    public static int findNthDigit(long n) {
        long len = 1, cnt = 9, start = 1;
        while (n > len * cnt) {
            n -= len * cnt;
            ++len;
            cnt *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String t = String.valueOf(start);
        return t.charAt((int)((n - 1) % len)) - '0';
    }
}
