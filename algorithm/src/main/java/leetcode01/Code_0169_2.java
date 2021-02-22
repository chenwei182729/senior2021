package leetcode01;

public class Code_0169_2 {
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(int[] a, int lo, int hi) {
        if (lo == hi) {
            return a[lo];
        }
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElement(a, lo, mid);
        int right = majorityElement(a, mid + 1, hi);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(a, left, lo, mid);
        int rightCount = countInRange(a, right, mid + 1, hi);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] a, int val, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (a[i] == val) {
                count++;
            }
        }
        return count;
    }
}
