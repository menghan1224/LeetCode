package Exer;

/**
 * Created by menghan on 2017/8/1.
 */
public class BTStockI {
    public int maxProfit(int[] prices) {
        int res=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]) res+=prices[i]-prices[i-1];
        }
        return res;
    }
}
