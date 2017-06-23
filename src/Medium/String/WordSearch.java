package Medium.String;

/**
 * Created by menghan on 2017/6/16.
 */
public class WordSearch {
    public boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)&&search(board,i,j,0,word)) return true;
            }
        }
        return false;
    }
    public boolean search(char[][] board,int i,int j,int index,String word){
        if(index==word.length()) return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length) return false;
        if(board[i][j]!=word.charAt(index)||visited[i][j]) return false;
        visited[i][j]=true;
        if(search(board,i+1,j,index+1,word)||
                search(board,i-1,j,index+1,word)||
                search(board,i,j-1,index+1,word)||
                search(board,i,j+1,index+1,word)) return true;
        visited[i][j]=false;
        return false;

    }

}
