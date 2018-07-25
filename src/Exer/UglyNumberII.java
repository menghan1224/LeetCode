package Exer;

/**
 * Created by menghan on 2017/7/4.
 */
public class UglyNumberII {
    public static void main(String[] args){
        int a=new UglyNumberII().nthUglyNumber(11);
        System.out.println(a);
    }
    public int nthUglyNumber(int n) {
        if(n<1) return 0;
        int[] res=new int[n];
        res[0]=1;
        int index2=0,index3=0,index5=0;
        for(int i=1;i<n;i++){
            int num=Math.min(res[index2]*2,Math.min(res[index3]*3,res[index5]*5));
            res[i]=num;
            while(res[index2]*2<=num) index2++;
            while(res[index3]*3<=num) index3++;
            while(res[index5]*5<=num) index5++;
        }
        return res[n-1];
    }
}
