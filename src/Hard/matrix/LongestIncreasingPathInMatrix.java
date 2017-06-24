package Hard.matrix;

/**
 * Created by menghan on 2017/6/24.
 */
public class LongestIncreasingPathInMatrix {
    int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int max=0;
        if(matrix.length==0||matrix[0].length==0) return max;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] cache=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,dfs(matrix,i,j,cache));
            }
        }
        return max;
    }
    public int dfs(int[][] matrix,int i,int j,int[][] cache){
        if(cache[i][j]!=0) return cache[i][j];
        int max=1;
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x<0||x>=matrix.length||y<0||y>=matrix[0].length||matrix[i][j]>=matrix[x][y]) continue;
            max=Math.max(max,1+dfs(matrix,x,y,cache));
        }
        cache[i][j]=max;
        return max;
    }
}
