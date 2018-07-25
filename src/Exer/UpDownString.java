package Exer;

/**
 * Created by menghan on 2017/10/24.
 */
public class UpDownString {
    private static String solution(String line) {
        char[] ops = line.toCharArray();
        int[] nums = new int[ops.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            nums[i - 1] = i;
        }

        int start = 0;
        while (start < ops.length) {
            while (start < ops.length && ops[start] == '+') {
                ++start;
            }

            if (start == ops.length) {
                break;
            }

            int end = start + 1;
            while (end < ops.length && ops[end] == '-') {
                ++end;
            }

            int left = start;
            int right = end;
            while (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                ++left;
                --right;
            }
            start = end;
        }
        StringBuilder sb = new StringBuilder();
        for (int n : nums) {
            sb.append(n);
        }
        return sb.toString();
    }
}
