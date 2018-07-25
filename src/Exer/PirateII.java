package Exer;

import java.util.Arrays;

/**
 * Created by menghan on 2017/10/24.
 */
public class PirateII {
    public static void main(String[] args) {
        System.out.println(solution("1,2,3;1,1"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(";");
        String[] pirates = strs[0].split(",");
        String[] coins = strs[1].split(",");
        int[] piratesI = new int[pirates.length];
        int[] coinsI = new int[coins.length];
        for(int i = 0;i<pirates.length;i++){
            piratesI[i] = Integer.parseInt(pirates[i]);
        }
        for(int i = 0;i<coins.length;i++){
            coinsI[i] = Integer.parseInt(coins[i]);
        }
        Arrays.sort(piratesI);
        Arrays.sort(coinsI);
        int count = 0;
        // 返回处理后的结果
        int i = 0,j=0;
        while(i<piratesI.length&&j<coinsI.length){
            if(piratesI[i]>coinsI[j]){
                j++;
            }else{
                i++;
                j++;
                count++;
            }
        }
        return count>pirates.length/2?"1":"0";
    }
}
