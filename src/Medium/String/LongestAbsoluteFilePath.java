package Medium.String;

import java.util.Stack;

/**
 * Created by 28479 on 2017/6/8.
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if (input == null)
            return 0;
        // stores length of parent level.
        Stack<Integer> p_dir = new Stack<>();

        // .charAt() may be expensive compared with accessing memory directly.
        char[] cin = input.toCharArray();
        int i = 0, res = 0;
        while (i < cin.length) {
            // current level length (append '/') and parent dir numbers
            int cur = 1, level = 0;
            boolean is_file = false;

            while (cin[i] == '\t') {
                level++;
                i++;
            }

            while (i < cin.length && cin[i] != '\n') {
                cur++;
                if (cin[i++] == '.')
                    is_file = true;
            }

            while (p_dir.size() > level) {
                p_dir.pop();
            }

            int cur_len = p_dir.isEmpty() ? cur : cur + p_dir.peek();
            // if it's a file, you wont have to append '/'
            if (is_file) res = Math.max(res, cur_len-1);
            p_dir.push(cur_len);

            i++;
        }
        return res;
    }
}
