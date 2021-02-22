package leetcode01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenxinwei
 * @date 2021/2/18 17:02
 **/
public class Code_0047 {
    private List<List<Integer>> result;
    private List<Integer> temp;
    private boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            temp.add(nums[i]);
            vis[i] = true;

            backtrack(nums, index + 1);
            vis[i] = false;
            temp.remove(index);
        }
    }
}
