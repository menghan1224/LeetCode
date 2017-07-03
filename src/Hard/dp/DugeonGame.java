package Hard.dp;

/**
 * Created by menghan on 2017/7/1.
 */
public class DugeonGame {
    public static void main(String[] args){
        System.out.println(new DugeonGame().calculateMinimumHP(new int[][]{{2,1},{1,-1}}));
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        if(m==0) return 0;
        int n=dungeon[0].length;
        if(n==0) return 0;
        dungeon[m-1][n-1]=dungeon[m-1][n-1]<0?-dungeon[m-1][n-1]:0;
        for(int i=m-2;i>=0;i--){
            dungeon[i][n-1]=dungeon[i+1][n-1]>dungeon[i][n-1]?dungeon[i+1][n-1]-dungeon[i][n-1]:0;
        }
        for(int i=n-2;i>=0;i--){
            dungeon[m-1][i]=dungeon[m-1][i+1]>dungeon[m-1][i]?dungeon[m-1][i+1]-dungeon[m-1][i]:0;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                int down=dungeon[i+1][j]>dungeon[i][j]?dungeon[i+1][j]-dungeon[i][j]:0;
                int right=dungeon[i][j+1]>dungeon[i][j]?dungeon[i][j+1]-dungeon[i][j]:0;
                dungeon[i][j]=Math.min(down,right);
            }
        }
        return dungeon[0][0]+1;
    }
}
