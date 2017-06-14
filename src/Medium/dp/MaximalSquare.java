package Medium.dp;

/**
 * Created by 28479 on 2017/6/14.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] res=new int[matrix.length+1][matrix[0].length+1];
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    res[i+1][j+1]=Math.min(res[i-1][j],Math.min(res[i][j-1],res[i-1][j-1]))+1;
                    if(res[i+1][j+1]>max) max=res[i+1][j+1];
                }
            }
        }
        return max*max;
    }
}
