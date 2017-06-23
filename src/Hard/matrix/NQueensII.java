package Hard.matrix;

/**
 * Created by menghan on 2017/6/23.
 */
public class NQueensII {
    int count=0;
    int res[];
    public int totalNQueens(int n) {
        res=new int[n];
        getcount(0,n);
        return count;
    }
    public void getcount(int cur,int n){
        if(cur==n) {
            count++;
            return;
        }
        for(int i=0;i<n;i++){
            res[cur]=i;
            if(isvalid(cur)) getcount(cur+1,n);
        }
    }
    public boolean isvalid(int cur){
        for(int i=0;i<cur;i++){
            if(res[i]==res[cur]||Math.abs(res[i]-res[cur])==cur-i) return false;
        }
        return true;
    }
}
