package Easy;

/**
 * Created by 28479 on 2017/6/3.
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long low=1;
        long high=num/2;
        if(num==1) return true;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(mid*mid==num) return true;
            else if(mid*mid<num) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}
