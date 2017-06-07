package Medium.matrix;

/**
 * Created by 28479 on 2017/6/7.
 */
public class SprialMatrixII {
    public int[][] generateMatrix(int n) {
        int result[][] = new int[n][n];
        int num = 1;
        int x = 0, y = 0, mx = n, my = n;
        while (x < mx && y < my) {
            for (int i = y; i < my; i++) {
                result[x][i] = num++;
            }
            x++;
            for (int i = x; i < mx; i++) {
                result[i][my - 1] = num++;
            }
            my--;
            for (int i = my - 1; i >= y; i--) {
                result[mx - 1][i] = num++;
            }
            mx--;
            for (int i = mx - 1; i >= x; i--) {
                result[i][y] = num++;
            }
            y++;
        }
        return result;
    }
}
