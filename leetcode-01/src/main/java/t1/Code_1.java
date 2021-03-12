package t1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxinwei
 * @date 2021/3/11 17:26
 **/
public class Code_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);
            if (val == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{val, i};
            }
        }
        return null;
    }
}
