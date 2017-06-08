package Medium.Array;

import java.util.Arrays;

/**
 * Created by 28479 on 2017/6/8.
 */
public class Hindex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max=0;
        for (int i = citations.length - 1; i >= 0&&citations[i]>=citations.length-i; i--) {
            max=citations.length-i;
        }
        return max;
    }
}
