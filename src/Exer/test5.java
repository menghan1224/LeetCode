package Exer;

import javafx.scene.input.InputMethodTextRun;
import org.omg.CORBA.INTERNAL;

import java.util.HashSet;

/**
 * Created by menghan on 2017/10/11.
 */
public class test5 {
    public static void main(String[] args) {
        System.out.println(solution("2;2;0;0;2;0"));
    }
    private static int count = Integer.MAX_VALUE;
    private static int n;
    private static int m;
    private static boolean[][] cache;
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(";");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        cache = new boolean[n+1][m+1];
        int initX = Integer.parseInt(strs[2]);
        int initY = Integer.parseInt(strs[3]);
        int tarX =Integer.parseInt(strs[4]);
        int tarY = Integer.parseInt(strs[5]);
        dfs(initX,initY,tarX,tarY,0);
        return count==Integer.MAX_VALUE?-1+"":count+"";

    }
    public static void dfs(int x,int y,int ax,int ay,int steps){
        if(steps>count) return;
        if(x<0||y<0||x>n||y>m||cache[x][y]) return;
        cache[x][y]=true;
        if(x==ax&&y==ay&&steps<count) count=steps;
        dfs(x+1,y+2,ax,ay,steps+1);
        dfs(x-1,y+2,ax,ay,steps+1);
        dfs(x+2,y+1,ax,ay,steps+1);
        dfs(x-2,y+1,ax,ay,steps+1);
        dfs(x+2,y-1,ax,ay,steps+1);
        dfs(x-2,y-1,ax,ay,steps+1);
        dfs(x+1,y-2,ax,ay,steps+1);
        dfs(x-1,y-2,ax,ay,steps+1);
        cache[x][y]=false;

    }
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
}
