package leetcode01;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * public void recur(int level,int param) {
 * <p>
 * // terminator
 * if (level > MAX_LEVEL) {
 * return ;
 * }
 * <p>
 * //process current logic
 * process(level,param);
 * <p>
 * <p>
 * // drill down
 * recur(level: level + 1,newParam);
 * // restore current status
 * }
 */
public class Code_0022_2 {
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        _generate(0, 0, n, "");
        return result;
    }

    private void _generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        if (left < n) {
            _generate(left + 1, right, n, s + "(");
        }
        //(right < n && right < left)  right如果小于left的话，肯定小于n,故可以写成 right < left
        if (right < left) {
            _generate(left, right + 1, n, s + ")");
        }
    }


    public static void main(String[] args) {
        Code_0022_2 code_0022 = new Code_0022_2();
        System.out.println(code_0022.generateParenthesis(3));
    }
}
