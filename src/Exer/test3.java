package Exer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by menghan on 2017/10/10.
 */
public class test3 {
    public static void main(String[] args) {
        System.out.println(solution("30,92,49,20,85,20,54,3,20,59,52,98,44,94,84,26,20,42,62,55,27,19,92,34,81,44,16,67,15,8,24,37,64,52,79,16,8,87,24,96,34,23,1,77,85,70,28,24,30,8,43,32,66,66,36,28,71,72,6,3,80,43,69,36,61,73,63,64,53,24,61,48,89,87,55,69,33,54,56,46,86,44,72,80,9,70,22,26,58,55,24,68,80,49,4,63,17,59,43,41,85,56,11,5,24,3,13,87,31,52,57,23,6,74,59,99,57,43,48,65,36,51,55,84,37,91,94,61,70,13,2,3,96,69,14,23,5,77,47,90,73,11,82,6,96,67,85,28,22,58,21,80,68,5,98,83,97,7,54,72,32,94,63,45,87,37,98,4,60,42,68,57,22,76,82,70,99,90,82,26,72,27,18,5,6,2,89,40,55,36,95,60,33,43"));
    }
    private static String solution(String line) {
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(strs[i]);
            if(map.containsKey(arr[i])) map.get(arr[i]).add(i);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i],list);
            }
        }
        int count = 0;
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            if(map.containsKey(10-num)){
                List<Integer> list = map.get(10-num);
                int index = 0;
                while(index<list.size()&&list.get(index)<i) index++;
                count+=list.size()-index;
            }if(map.containsKey(num+10)){
                List<Integer> list = map.get(10+num);
                int index = 0;
                while(index<list.size()&&list.get(index)<i) index++;
                count+=list.size()-index;
            }if(map.containsKey(num-10)){
                List<Integer> list = map.get(num-10);
                int index = 0;
                while(index<list.size()&&list.get(index)<i) index++;
                count+=list.size()-index;
            }
        }
        return count+"";
    }
    private static String cmp(String s1,String s2){
        if(s1.length()>s2.length()) return "Y";
        else if(s1.length()<s2.length()) return "N";
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)>s2.charAt(i)) return "Y";
            else if(s1.charAt(i)<s2.charAt(i)) return "N";
        }
        return "N";
    }
    private static String add(String s1,String s2){
        String sb1 = new StringBuilder(s1).reverse().toString();
        String sb2 = new StringBuilder(s2).reverse().toString();
        String res = "";
        int i = 0;
        int carry = 0;
        for(;i<Math.min(s1.length(),s2.length());i++){
            int a1 = sb1.charAt(i)-'0';
            int a2 = sb2.charAt(i)-'0';
            res=((a1+a2+carry)%10)+res;
            carry=(a1+a2+carry)/10;
        }
        while(i<sb1.length()){
            int a1 = sb1.charAt(i)-'0';
            res=((a1+carry)%10)+res;
            carry = (a1+carry)/10;
            i++;
        }
        while(i<sb2.length()){
            int a1 = sb2.charAt(i)-'0';
            res=((a1+carry)%10)+res;
            carry = (a1+carry)/10;
            i++;
        }
        if(carry!=0) res=carry+res;
        return res;
    }
    private static int search(int[] arr,int begin,int end){
        int index = begin;
        int tmp = arr[begin];
        for(int i=begin;i<=end;i++){
            if(arr[i]<tmp){
                index = i;
                tmp= arr[i];
            }
        }
        return index;
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] outNums=new Set[numCourses];
        for(int i=0;i<numCourses;i++)
            outNums[i]=new HashSet<Integer>();
        for(int[] edge:prerequisites){
            outNums[edge[1]].add(edge[0]);
        }
        int[] insize=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            Set<Integer> set=outNums[i];
            for(int num:set){
                insize[num]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            int j=0;
            for(;j<numCourses;j++){
                if(insize[j]==0) break;
            }
            if(j==numCourses) return false;
            insize[j]=-1;
            for(int num:outNums[j]){
                insize[num]--;
            }
        }
        return true;
    }
}
