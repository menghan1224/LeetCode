package Exer;

import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by menghan on 2017/10/19.
 */
public class FindDengChaShuLie {

    public static void main(String[] args) {

    }

    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(" ");
        int[] a = new int[strs.length];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<a.length;i++) {
            a[i] = Integer.parseInt(strs[i]);
            if(map.get(a[i])==null){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(a[i],list);
            }
            else map.get(a[i]).add(i);
        }
        int count = a.length*(a.length-1)/2;
        boolean isFinish = false;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                int diff = a[j]-a[i];
                int tar = a[j]+diff;
                count+=search(map,tar,diff,j);
            }
        }
        // 返回处理后的结果
        return count+"";
    }
    public static int search(Map<Integer,List<Integer>> map,int tar,int diff,int index){
        if(map.get(tar)==null) return 0;
        List<Integer> list = map.get(tar);
        int len = list.size()-1;
        int search = binarySearch(list,index);
        if(list.get(search)>index) search--;
        if(len-search==0) return 0;
        int sum = 0;
        sum+=len-search;
        for(int i = search+1;i<=len;i++){
            sum+=search(map,tar+diff,diff,list.get(i));
        }
        return sum;
    }
    public static int binarySearch(List<Integer> list,int target){
        int begin = 0;
        int end =list.size()-1;
        while(begin<end){
            int mid = begin+(end-begin)/2;
            if(list.get(mid)==target) return mid;
            else if(list.get(mid)>target) end = mid-1;
            else begin = mid+1;
        }
        return begin;
    }
}
