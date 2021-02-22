package leetcode01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxinwei
 * @date 2021/2/18 16:39
 **/
public class Code_0077 {
    private List<List<Integer>> result;
    private List<Integer> temp;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        temp = new ArrayList<>();

        dfs(1, n, k);
        return result;
    }

    private void dfs(int cur, int n, int k) {
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k);
    }

    public static void main(String[] args) {
        Code_0077 code_0077 = new Code_0077();
        code_0077.combine(4, 2);
    }
}
