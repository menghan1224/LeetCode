package Exer;

import java.util.Arrays;

/**
 * Created by menghan on 2017/10/10.
 */
public class test4 {
    public static void main(String[] args) {
        System.out.println(solution("3;2;4 2 1;1 1;2 2"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(";");
        int numArr = Integer.parseInt(strs[0]);
        int numQuery = Integer.parseInt(strs[1]);
        String arrS[] = strs[2].split(" ");
        int[] arr = new int[arrS.length];
        for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(arrS[i]);
        Arrays.sort(arr);
        int res = 0;
        int[] count = new int[numArr];
        for(int i=3;i<3+numQuery;i++){
            String[] tmp = strs[i].split(" ");
            int begin = Integer.parseInt(tmp[0]);
            int end = Integer.parseInt(tmp[1]);
            for(int j=begin;j<=end;j++) count[j]++;
        }
        int[] queryCount = new int[numQuery+1];
        for(int i=0;i<count.length;i++){
            queryCount[count[i]]++;
        }
        int index = arr.length-1;
        for(int i=queryCount.length-1;i>=1;i--){
            while(queryCount[i]-->0){
                res+=i*arr[index--];
            }
        }
        // 返回处理后的结果
        return res+"";
    }
    public static boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=getNum(slow);
            fast=getNum(fast);
            fast=getNum(fast);
        }while(slow!=fast);
        if(slow==1) return true;
        return false;

    }
    public static int getNum(int n){
        int res=0,temp;
        while(n!=0){
            temp=n%10;
            res+=temp*temp;
            n/=10;
        }
        return res;
    }
}
