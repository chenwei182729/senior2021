package jindian;

/**
 * @author chenxinwei
 * @date 2020/12/30 17:48
 **/
public class LeetCode01_04_2 {
    //待解决
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[]{};
        }
        int start = k - 1;
        int[] ret = new int[nums.length - start];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(nums[i], maxValue);
            if (i >= start) {
                ret[i - start] = maxValue;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        final LeetCode01_04_2 leetCode01_042 = new LeetCode01_04_2();
        int[] nums = new int[]{};
        final int[] ints = leetCode01_042.maxSlidingWindow(nums, 0);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
