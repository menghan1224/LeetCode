package Medium.dp;

import java.util.Arrays;

/**
 * Created by 28479 on 2017/6/16.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] res=new int[amount+1];
        for(int i=1;i<=amount;i++){
            int min=-1;
            for(int coin:coins){
                if(i>=coin&&res[i-coin]!=-1){
                    int temp=res[i-coin]+1;
                    res[i]=min<0?temp:temp<min?temp:min;
                }
            }
            res[i]=min;
        }
        return res[amount];
    }
}
