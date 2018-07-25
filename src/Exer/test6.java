package Exer;

import java.util.HashSet;

/**
 * Created by menghan on 2017/10/11.
 */
public class test6 {
    public static void main(String[] args) {
        System.out.println(solution("5,3,-,6,-,-,-,9,8 -,7,-,1,9,5,-,-,- -,-,-,-,-,-,-,6,- 8,-,-,4,-,-,7,-,- -,6,-,8,-,3,-,2,- -,-,3,-,-,1,-,-,6 -,6,-,-,-,-,-,-,- -,-,-,4,1,9,-,8,- 2,8,-,-,-,5,-,7,9"));
    }
    private static int count = Integer.MAX_VALUE;
    private static int n;
    private static int m;
    private static boolean[][] cache;
    private static int[][] arr={{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
    private static String solution(String line) {
        // 在此处理单行数据
        char[][] board = new char[9][9];
        String[] strs = line.split(" ");
        for(int i=0;i<9;i++){
            int rowBegin = i/3*3;
            int colBegin = i%3*3;
            String[] tmp = strs[i].split(",");
            for(int j=0;j<9;j++){
                board[rowBegin+j/3][colBegin+j%3] = tmp[j].charAt(0);
            }
        }
        boolean res = isValidSudoku(board);
        return res+"";

    }
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='-' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='-' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='-' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
    public static void dfs(int x,int y,int ax,int ay,int steps){
        if(steps>count) return;
        if(x==ax&&y==ay){
            if(steps<count) count=steps;
            return;
        }
        for(int i=0;i<arr.length;i++){
            int tx = x+arr[i][0];
            int ty = y+arr[i][1];
            if(tx<0||ty<0||tx>n||ty>m) continue;
            if(!cache[tx][ty]){
                cache[tx][ty] = true;
                dfs(tx,ty,ax,ay,steps+1);
                cache[tx][ty]=false;
            }
        }

    }
}
