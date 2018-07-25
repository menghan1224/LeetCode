package Exer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by menghan on 2017/10/10.
 */
public class test2 {
    public static void main(String[] args) {
        System.out.println(solution("67108864"));
    }
    private static final String[] geWei = { "零", "壹", "贰", "叁", "肆",
                         "伍", "陆", "柒", "捌", "玖" };
    private static String solution(String line) {
        long num = Long.parseLong(line);
        if(num==0) return "零元整";
        return getRes(num)+"元整";
    }
    private static String getRes(long num){
        if(num==0) return "";
        if(num<10){
            return geWei[(int)num];
        }else if(num<100){
            return getRes(num/10)+"拾"+getRes(num%10);
        }
        else if(num<1000){
            if(num%100>=10||num%100==0)
                return getRes(num/100)+"佰"+getRes(num%100);
            else
                return getRes(num/100)+"佰零"+getRes(num%100);
        }
        else if(num<10000){
            if(num%1000>=100||num%1000==0)
                return getRes(num/1000)+"仟"+getRes(num%1000);
            else
                return getRes(num/1000)+"仟零"+getRes(num%1000);
        }
        else if(num<100000000){
            if(num%10000>=1000||num%10000==0)
                return getRes(num/10000)+"万"+getRes(num%10000);
            else return getRes(num/10000)+"万零"+getRes(num%10000);
        }
        else {
            if(num%100000000>=10000000||num%100000000==0)
                return getRes(num/100000000)+"亿"+getRes(num%100000000);
            else return getRes(num/100000000)+"亿零"+getRes(num%100000000);
        }
    }
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - s.peek()-1));
                i--;
            }
        }
        return maxArea;
    }
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }
    private static int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }
    public static boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    public static int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }
}
