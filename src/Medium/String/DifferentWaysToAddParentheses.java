package Medium.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/6.
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '+' && c != '-' && c != '*') {
                continue;
            }
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
            for (int l : left) {
                for (int r : right) {
                    if (c == '+') {
                        result.add(l + r);
                    } else if (c == '-') {
                        result.add(l - r);
                    } else if (c == '*') {
                        result.add(l * r);
                    }
                }
            }
        }
        if (result.size() == 0) { //when there is only an integer
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}
