package Medium.matrix;

/**
 * Created by menghan on 2017/6/23.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board.length<2||board[0].length<2) return;
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][n-1]=='O') dfs(board,i,n-1);
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O') dfs(board,0,j);
            if(board[m-1][j]=='O') dfs(board,m-1,j);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='*') board[i][j]='O';
                else  if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length) return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i-1][j] == 'O')
            dfs(board, i-1, j);
        if (i < board.length - 2 && board[i+1][j] == 'O')
            dfs(board, i+1, j);
        if (j > 1 && board[i][j-1] == 'O')
            dfs(board, i, j-1);
        if (j < board[i].length - 2 && board[i][j+1] == 'O' )
            dfs(board, i, j+1);
    }
}
