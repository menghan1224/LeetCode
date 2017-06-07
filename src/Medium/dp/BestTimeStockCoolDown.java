package Medium.dp;

/**
 * Created by 28479 on 2017/6/7.
 */
public class BestTimeStockCoolDown {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int[] buys=new int[prices.length];
        int[] sells=new int[prices.length];
        buys[0]=-prices[0];
        for(int i=1;i<prices.length;i++){
            int diff=prices[i]-prices[i-1];
            sells[i]=Math.max(sells[i-1]+diff,buys[i-1]+prices[i]);
            if(i==1){
                buys[i]=buys[i-1]-diff;
            }else{
                buys[i]=Math.max(buys[i-1]-diff,sells[i-2]-prices[i]);
            }
        }
        int max=0;
        for(int num:sells){
            if(num>max) max=num;
        }
         return max;
    }
}
