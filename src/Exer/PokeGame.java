package Exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by menghan on 2017/10/18.
 */
public class PokeGame {
    public static void main(String[] args) {
        System.out.println(solution("10 5 6 A 8,10 5 6 A K"));
    }
    static class Pai{
        public boolean shunzi = true;
        public boolean sitiao = false;
        public boolean hulu = false;
        public boolean santiao = false;
        public boolean liangdui = false;
        public boolean yidui = false;
        public boolean single = false;
        public int[] arr;
        public int[] count;
        public Map<Integer,List<Integer>> map = new HashMap<>();
        public Pai(int[] arr){
            this.arr= arr;
            this.count = new int[15];
            Arrays.sort(arr);
            for(int i=0;i<arr.length;i++){
                if(i<arr.length-1&&arr[i+1]-arr[i]!=1) shunzi = false;
                count[arr[i]]++;
            }
            if(!shunzi){
                for(int i=1;i<=14;i++){
                    if(count[i]!=0){
                        if(map.get(count[i])!=null) map.get(count[i]).add(i);
                        else{
                            List<Integer> list = new ArrayList<>();
                            list.add(i);
                            map.put(count[i],list);
                        }
                    }
                }
                if(map.get(4)!=null) sitiao = true;
                else if(map.get(3)!=null){
                    if(map.get(2)!=null) hulu = true;
                    santiao = true;
                }
                else if(map.get(2)!=null){
                    if(map.get(2).size()==2) liangdui = true;
                    else yidui = true;
                }
                else single = true;
            }
        }
    }
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(",");
        String[] s1 = strs[0].split(" ");
        String[] s2 = strs[1].split(" ");
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        for(int i=0;i<5;i++){
            if(s1[i].equals("A")) arr1[i]=14;
            else if(s1[i].equals("J")) arr1[i]=11;
            else if(s1[i].equals("Q")) arr1[i]=12;
            else if(s1[i].equals("K")) arr1[i]=13;
            else arr1[i] = Integer.parseInt(s1[i]);
        }
        for(int i=0;i<5;i++){
            if(s2[i].equals("A")) arr2[i]=14;
            else if(s2[i].equals("J")) arr2[i]=11;
            else if(s2[i].equals("Q")) arr2[i]=12;
            else if(s2[i].equals("K")) arr2[i]=13;
            else arr2[i] = Integer.parseInt(s2[i]);
        }
        Pai p1 = new Pai(arr1);
        Pai p2 = new Pai(arr2);
        if(p1.shunzi){
            if(!p2.shunzi) return "win";
            else return p1.arr[4]>p2.arr[4]?"win":(p1.arr[4]==p2.arr[4]?"draw":"lose");
        }
        if(p1.sitiao){
            if(p2.shunzi) return "lose";
            if(!p2.sitiao) return "win";
            int n1 = p1.map.get(4).get(0);
            int n2 = p2.map.get(4).get(0);
            if(n1>n2) return "win";
            else if(n1<n2) return "lose";
            else{
                int n11 = p1.map.get(1).get(0);
                int n21 = p2.map.get(1).get(0);
                if(n11>n21) return "win";
                else if(n11<n21) return "lose";
                else return "draw";
            }
        }
        if(p1.hulu){
            if(p2.shunzi||p2.sitiao) return "lose";
            if(!p2.hulu) return "win";
            int n13 = p1.map.get(3).get(0);
            int n23 = p2.map.get(3).get(0);
            int n12 = p1.map.get(2).get(0);
            int n22 = p1.map.get(2).get(0);
            if(n13>n23) return "win";
            else if(n13<n23) return "lose";
            else{
                if(n12>n22) return "win";
                else if(n12<n22) return "lose";
                else return "draw";
            }
        }
        if(p1.santiao){
            if(p2.shunzi||p2.sitiao||p2.hulu) return "lose";
            if(!p2.santiao) return "win";
            int n13 = p1.map.get(3).get(0);
            int n23 = p2.map.get(3).get(0);
            if(n13>n23) return "win";
            else if(n13<n23) return "lose";
            else{
                List<Integer> l1 = p1.map.get(1);
                List<Integer> l2 = p2.map.get(1);
                return getCompare(l1,l2);
            }
        }
        if(p1.liangdui){
            if(p2.shunzi||p2.sitiao||p2.hulu||p2.santiao) return "lose";
            if(!p2.liangdui) return "win";
            List<Integer> l1 = p1.map.get(2);
            List<Integer> l2 = p2.map.get(2);
            if(getCompare(l1,l2).equals("draw")){
                List<Integer> l11 = p1.map.get(1);
                List<Integer> l21 = p2.map.get(1);
                return getCompare(l11,l21);
            }else return getCompare(l1,l2);
        }
        if(p1.yidui){
            if(p2.shunzi||p2.sitiao||p2.hulu||p2.santiao||p2.liangdui) return "lose";
            if(!p2.yidui) return "win";
            int n12 = p1.map.get(2).get(0);
            int n22 = p2.map.get(2).get(0);
            if(n12>n22) return "win";
            else if(n12<n22) return "lose";
            else{
                List<Integer> l1 = p1.map.get(1);
                List<Integer> l2 = p2.map.get(1);
                return getCompare(l1,l2);
            }
        }
        if(p1.single){
            if(!p2.single) return "lose";
            List<Integer> l1 = p1.map.get(1);
            List<Integer> l2 = p2.map.get(1);
            return getCompare(l1,l2);
        }
        // 返回处理后的结果
        return "";
    }
    private static String getCompare(List<Integer> l1,List<Integer> l2){
        for(int i=l1.size()-1;i>=0;i--){
            if(l1.get(i)>l2.get(i)) return "win";
            else if(l1.get(i)<l2.get(i)) return "lose";
        }
        return "draw";
    }
}

