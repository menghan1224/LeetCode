package Medium.Array;

/**
 * Created by 28479 on 2017/6/14.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] remain = new int[gas.length];
        for(int i = 0;i<gas.length;i++) {
            remain[i] = gas[i] - cost[i];
        }
        if(gas.length==0) return -1;
        int start = remain.length;
        int end = 0;
        int sum = 0;
        while(start!=end) {
            if(sum>=0) sum +=remain[end++];
            else sum+= remain[--start];
        }
        if(sum<0) return -1;
        return start==gas.length?0:start;
    }
}
