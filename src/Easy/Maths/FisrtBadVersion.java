package Easy.Maths;

/**
 * Created by 28479 on 2017/6/4.
 */
public class FisrtBadVersion {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }
    boolean isBadVersion(int version){
        return true;
    }
}
