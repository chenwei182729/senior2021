package leetcode01;

import java.util.HashMap;
import java.util.Map;

public class Code_0001 {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            Integer index = valIndexMap.get(res);
            if (index != null) {
                return new int[]{index, i};
            } else {
                valIndexMap.put(nums[i], i);
            }
        }
        return null;
    }
}
