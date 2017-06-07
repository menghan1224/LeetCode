package Medium.Array;

/**
 * Created by 28479 on 2017/6/7.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int res[]=new int[n];
        int idx[]=new int[primes.length];
        res[0]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<primes.length;j++){
                res[i]=Math.min(res[i],primes[j]*res[idx[j]]);
            }
            for(int j=0;j<primes.length;j++){
                while(primes[j]*res[idx[j]]<=res[i]) idx[j]++;
            }
        }
        return res[n-1];
    }
}
