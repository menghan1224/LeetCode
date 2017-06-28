package Hard.dp;

import java.util.Arrays;

/**
 * Created by menghan on 2017/6/28.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        int left[]=new int[n];
        int right[]=new int[n];
        int height[]=new int[n];
        Arrays.fill(left,0);
        Arrays.fill(right,n);
        int maxarea=0;
        for(int i=0;i<m;i++){
            int curleft=0,curright=n;
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1') left[j]=Math.max(left[j],curleft);
                else{
                    left[j]=0;
                    curleft=j+1;
                }
            }
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]=='1') right[j]=Math.min(right[j],curright);
                else{
                    right[j]=n;
                    curright=j;
                }
            }
            for(int j=0;j<n;j++) maxarea=Math.max((right[j]-left[j])*height[j],maxarea);
        }
        return maxarea;
    }
}
