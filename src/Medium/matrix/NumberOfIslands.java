package Medium.matrix;

/**
 * Created by 28479 on 2017/6/8.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        int num=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    num++;
                    search(grid,i,j);
                }
            }
        }
        return num;
    }
    public void search(char[][] grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length) return;
        if(grid[i][j]=='1'){
            grid[i][j]='0';
            search(grid,i+1,j);
            search(grid,i-1,j);
            search(grid,i,j+1);
            search(grid,i,j-1);
        }
    }
}
