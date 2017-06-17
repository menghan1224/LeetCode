package Medium.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/16.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int x=0,y=0;
        int mx=matrix.length;
        if(mx==0) return list;
        int my=matrix[0].length;
        while(x<mx&&y<my){
            for(int i=y;i<my;i++){
                list.add(matrix[x][i]);
            }
            x++;
            for(int i=x;i<mx;i++){
                list.add(matrix[i][my-1]);
            }
            my--;
            if(x<=mx-1) {
                for (int i = my - 1; i >= y; i--) {
                    list.add(matrix[mx - 1][i]);
                }
            }
            mx--;
            if(y<=my-1) {
                for (int i = mx - 1; i >= x; i--) {
                    list.add(matrix[i][y]);
                }
            }
            y++;
        }
        return list;
    }
}
