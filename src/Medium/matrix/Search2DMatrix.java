package Medium.matrix;

/**
 * Created by 28479 on 2017/6/8.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int begin=0;
        int end=m*n-1;
        while(begin<end){
            int mid=(begin+end)/2;
            if(matrix[mid/n][mid%n]==target) return true;
            else if(matrix[mid/n][mid%n]<target){
                begin=mid+1;
            }else end=mid-1;
        }
        return matrix[begin/n][begin%n]==target;
    }
}
