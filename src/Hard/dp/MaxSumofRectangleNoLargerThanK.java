package Hard.dp;

import java.util.TreeSet;

/**
 * Created by menghan on 2017/6/24.
 */
public class MaxSumofRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m=matrix.length;
        int n=matrix[0].length;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int[] sum=new int[m];
            for(int j=i;j<n;j++){
                for(int z=0;z<m;z++){
                    sum[z]+=matrix[z][j];
                }
                TreeSet<Integer> set=new TreeSet<>();
                int add=0;
                for(int z=0;z<m;z++){
                    add+=sum[z];
                    if(add<=k) res=Math.max(add,res);
                    Integer num=set.ceiling(add-k);
                    if(num!=null) res=Math.max(add-num,res);
                    set.add(add);
                }
            }
        }
        return res;
    }
}
