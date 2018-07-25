package Exer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by menghan on 2017/10/17.
 */
public class findNthNumber {
    public static void main(String[] args) {
        System.out.println(findNthNumber.solution("7"));
    }
    private static int[] index={0,1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2};
    private static List<int[]> list = new ArrayList<>();
    private static String solution(String line) {
        long n = Long.parseLong(line);
        long i=1;
        for(;(i+2)*(i+1)/2<=n;i++){

        }
        long res = i*(i+1)/2;
        long p = 0;
        if(res==n) p = find(i,i);
        else p = find(i+1,n-res);
        return p+"";
    }
    public static long find(long rows,long kth){
        int res = (int)((kth-1)%16+1);
        return index[res];
    }
    public static void dfs(boolean[][] cache,int[][] matrix,int[][] res,int i,int j,int preI,int preJ){
        if(i==0||j==0) res[preI][preJ]|=1;
        if(i==matrix.length-1||j==matrix[0].length-1) res[preI][preJ]|=2;
        cache[i][j] = true;
        if(i-1>=0&&matrix[i-1][j]<=matrix[i][j]&&!cache[i-1][j]) dfs(cache,matrix,res,i-1,j,preI,preJ);
        if(i+1<matrix.length&&matrix[i+1][j]<=matrix[i][j]&&!cache[i+1][j]) dfs(cache,matrix,res,i+1,j,preI,preJ);
        if(j-1>=0&&matrix[i][j-1]<=matrix[i][j]&&!cache[i][j-1]) dfs(cache,matrix,res,i,j-1,preI,preJ);
        if(j+1<matrix[0].length&&matrix[i][j+1]<=matrix[i][j]&&!cache[i][j+1]) dfs(cache,matrix,res,i,j+1,preI,preJ);
        cache[i][j] = false;

    }

}
