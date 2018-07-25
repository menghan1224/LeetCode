package Exer;

import java.util.Arrays;

/**
 * Created by menghan on 2017/10/19.
 */
public class Aziteke {
    public static void main(String[] args) {
        System.out.println(solution("2,3,9"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(",");
        int[] a = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            a[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(a);
        int sum = 0;
        int i=a.length-1;
        for (; i > 2; i = i - 2)
        {
            //最小者将最大2个送走或最小2个将最大2个送走
            if (a[0] + a[1] + a[1] + a[i] < a[0] + a[0] + a[i - 1] + a[i])
                sum = sum + a[0] + a[1] + a[1] + a[i];
            else
                sum = sum + a[0] + a[0] + a[i - 1] + a[i];
        }
        if (i == 2)
            sum = sum + a[0] + a[1] + a[2];
        else if (i == 1)
            sum = sum + a[1];
        else
            sum = a[0];
        // 返回处理后的结果
        return sum+"";
    }
}
