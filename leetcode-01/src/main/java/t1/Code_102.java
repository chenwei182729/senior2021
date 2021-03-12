package t1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxinwei
 * @date 2021/3/12 18:16
 **/
public class Code_102 {
    private List<List<Integer>> ans;
    private List<Integer> temp;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        _traval(1, n, k);
        return ans;
    }

    private void _traval(int cur, int n, int k) {
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(cur);
        _traval(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        _traval(cur + 1, n, k);
    }

    public static void main(String[] args) {
        Code_102 code_102 = new Code_102();
        System.out.println(code_102.combine(4, 2));
    }
}
