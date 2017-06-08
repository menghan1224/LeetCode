package Medium.Math;

/**
 * Created by 28479 on 2017/6/8.
 */
public class SuperPow {
    public int superPow(int a, int[] b) {
        if(isZero(b)) return 1;
        boolean isOdd;
        if(b[b.length-1]%2==0) isOdd=false;
        else isOdd=true;
        a=a%1337;
        divide(b,2);
        int res=superPow(a,b);
        res=res%1337;
        res*=res;
        res=res%1337;
        if(isOdd) res=(res*a)%1337;
        return res;
    }
    public void divide(int[] arr,int a){
        int tmp=0;
        for(int i=0;i<arr.length;i++){
            arr[i]+=tmp*10;
            tmp=arr[i]%a;
            arr[i]/=a;
        }
    }
    public boolean isZero(int[] arr) {
        for (int num : arr) {
            if (num != 0) return false;
        }
        return true;
    }
}
