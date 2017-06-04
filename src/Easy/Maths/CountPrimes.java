package Easy.Maths;

/**
 * Created by menghan on 2017/6/4.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int[] res=new int[n];
        int k=(int)Math.sqrt(n);
        int count=0;
        for(int i=2;i<=k;i++)
        {
            if(isPrime(i))
            {
                for(int j=i*i;j<n;j+=i)
                {
                    res[j-1]=1;
                }
            }
        }
        for(int i=1;i<res.length-1;i++)
        {
            if(res[i]==0)
                count++;
        }
        return count;
    }
    public  boolean isPrime(int num)
    {
        int k=(int)Math.sqrt(num);
        for(int i=2;i<=k;i++)
        {
            if(num%i==0)
                return false;
        }
        return true;
    }
}
