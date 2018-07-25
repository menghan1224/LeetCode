package Exer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by menghan on 2017/7/3.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length==0||matrix[0].length==0) return list;
        int x=0,nx=matrix.length-1,y=0,ny=matrix[0].length-1;
        while(x<=nx&&y<=ny) {
            for (int i = y; i <= ny; i++) {
                list.add(matrix[x][i]);
            }
            x++;
            for (int j = x; j <= nx; j++) {
                list.add(matrix[j][ny]);
            }
            ny--;
            if(x<=nx) {
                for (int m = ny; m >= y; m--) {
                    list.add(matrix[nx][m]);
                }
            }
            nx--;
            if(y<=ny) {
                for (int n = nx; n >= x; n--) {
                    list.add(matrix[n][y]);
                }
            }
            y++;
        }
        return list;
    }

}
