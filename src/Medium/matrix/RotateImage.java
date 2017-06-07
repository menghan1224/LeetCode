package Medium.matrix;

/**
 * Created by 28479 on 2017/6/7.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix.length==1)
            return;
        int length=matrix.length;
        for(int i=0;i<=(length-1)/2;i++)
        {
            for(int j=i;j<length-1-i;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[length-1-j][i];
                matrix[length-1-j][i]=matrix[length-1-i][length-1-j];
                matrix[length-1-i][length-1-j]=matrix[j][length-1-i];
                matrix[j][length-1-i]=temp;
            }
        }
    }
}
