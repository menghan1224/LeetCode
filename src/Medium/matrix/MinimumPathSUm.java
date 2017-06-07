package Medium.matrix;

/**
 * Created by 28479 on 2017/6/7.
 */
public class MinimumPathSUm {
    public int min(int x,int y)
    {
        return x<y?x:y;
    }
    public int minPathSum(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(i==0&&j==0)
                {
                    grid[0][0]=grid[0][0];
                }
                else if(i==0)
                {
                    grid[i][j]=grid[i][j-1]+grid[i][j];
                }
                else if(j==0)
                {
                    grid[i][j]=grid[i-1][j]+grid[i][j];
                }
                else
                {
                    grid[i][j]=min(grid[i-1][j],grid[i][j-1])+grid[i][j];
                }
            }


        }
        return grid[grid.length-1][grid[grid.length-1].length-1];
    }
}
