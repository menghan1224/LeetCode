package Easy;

/**
 * Created by 28479 on 2017/6/2.
 */
public class BestTimeStockII {
    public int maxProfit(int[] prices) {
        if(prices.length<=0) return 0;
        int smallPro=prices[0];
        int MaxPro=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>smallPro){
                MaxPro+=prices[i]-smallPro;
                smallPro=prices[i];
            }else{
                smallPro=prices[i];
            }
        }
        return MaxPro;
    }
}
