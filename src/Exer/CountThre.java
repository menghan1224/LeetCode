package Exer;

/**
 * Created by menghan on 2017/10/18.
 */
public class CountThre {
    public static void main(String[] args) {
        System.out.println(solution("7"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        int n = Integer.parseInt(line);
        int res = 1;
        while(n>0){
            if(res%7==0||check7(res)){
                res++;
                continue;
            }
            n--;
            res++;
        }
        // 返回处理后的结果
        return (res-1)+"";
    }
    public static boolean check7(int n){
        boolean includeSeven = false;
        while (n!=0){
            if(n%10==7) {
                includeSeven = true;
                break;
            }
            n/=10;
        }
        return includeSeven;
    }
    public static int digitCounts(int n) {
        // write your code here
        int num = 0;
        for (int i = 1;i<=n;i++){
            if(i%7==0||check7(i)) num++;
        }
        return num;
    }
}
