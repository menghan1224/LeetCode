package Easy;

/**
 * Created by menghan on 2017/6/2.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=getNum(slow);
            fast=getNum(fast);
            fast=getNum(fast);
        }while(slow!=fast);
        if(slow==1) return true;
        return false;

    }
    public int getNum(int n){
        int res=0,temp;
        while(n!=0){
            temp=n%10;
            res+=temp*temp;
            n/=10;
        }
        return res;
    }
}
