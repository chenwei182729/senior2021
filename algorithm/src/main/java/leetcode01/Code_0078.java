package leetcode01;

import java.util.ArrayList;
import java.util.List;

public class Code_0078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }

        dfs(ans, nums, new ArrayList<>(), 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(ans, nums, list, index + 1); // not pick the number at the index

        list.add(nums[index]);
        dfs(ans, nums, list, index + 1);// pick the number at the index

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Code_0078 code_0078 = new Code_0078();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = code_0078.subsets(nums);
        System.out.println(subsets);
    }
}
