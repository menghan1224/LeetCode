package Medium.matrix;

/**
 * Created by 28479 on 2017/6/17.
 */
public class NumMatrix {
    int[][] res;
    public NumMatrix(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return;
        res=new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                res[i+1][j+1]=matrix[i][j]+res[i][j+1]+res[i+1][j]-res[i][j];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(res==null) return 0;
        return res[row2+1][col2+1]-res[row1][col2+1]-res[row2+1][col1]+res[row1][col1];
    }
}
