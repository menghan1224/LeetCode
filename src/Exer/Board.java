package Exer;

/**
 * Created by menghan on 2017/10/19.
 */
public class Board {
    public static void main(String[] args) {
        System.out.println(solution("905"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        long tar = Long.parseLong(line);
        long begin = 1;
        long end= tar;
        while(begin<end){
            long mid = begin+ (end-begin)/2;
            if(getSum(mid)<tar){
                long tmp = getSum(mid+1);
                if(tmp>tar) return "-1";
                begin=mid+1;
            }else if(getSum(mid)>tar){
                end = mid-1;
            }else{
                return mid+"";
            }
        }
        long res = getSum(begin);
        // 返回处理后的结果
        return res==tar?begin+"":"-1";
    }
    public static long getSum(long n){
        long sum = 0;
        while(n!=0){
            sum+=n;
            n/=10;
        }
        return sum;
    }
}
