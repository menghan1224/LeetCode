package Medium.dp;

/**
 * Created by menghan on 2017/6/12.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;
        int[] res=new int[obstacleGrid[0].length];
        res[0]=1;
        for(int[] row:obstacleGrid){
            for(int j=0;j<row.length;j++){
                if(row[j]==1) res[j]=0;
                else if(j>0){
                    res[j]+=res[j-1];
                }
            }
        }
        return res[res.length-1];
    }
}
