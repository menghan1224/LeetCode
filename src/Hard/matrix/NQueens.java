package Hard.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by menghan on 2017/6/24.
 */
public class NQueens {
    public static void main(String[] args){
        System.out.println(new NQueens().solveNQueens(4));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        handle(0,new String[n],res,n,new boolean[n],new boolean[2*n],new boolean[2*n]);
        return res;
    }
    public void handle(int row,String[] res,List<List<String>> list,int n,boolean[] cols,boolean[] id1,boolean[] id2){
        if(row==n){
            List<String> sublist=new ArrayList<String>(Arrays.asList(res));
            list.add(sublist);
        }
        else{
            for(int col=0;col<n;col++){
                int va1=row-col+n,va2=2*n-row-col-1;
                if(!cols[col]&&!id1[va1]&&!id2[va2]){
                    char[] board=new char[n];
                    Arrays.fill(board,'.');
                    board[col]='Q';
                    res[row]=new String(board);
                    cols[col]=true;id1[va1]=true;id2[va2]=true;
                    handle(row+1,res,list,n,cols,id1,id2);
                    cols[col]=false;id1[va1]=false;id2[va2]=false;
                }
            }
        }

    }
}
