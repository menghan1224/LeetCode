package Easy.Array;

/**
 * Created by menghan on 2017/6/2.
 */
public class BestTimeStock {
    //one trade
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        if(prices.length==0) return 0;
        int smallest=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>smallest&&prices[i]-smallest>maxProfit){
                maxProfit=prices[i]-smallest;
            }else if(prices[i]<smallest){
                smallest=prices[i];
            }
        }
        return maxProfit;
    }
}
