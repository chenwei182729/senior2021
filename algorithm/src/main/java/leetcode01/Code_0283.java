package leetcode01;

public class Code_0283 {
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int j = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[j++] = num;
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }

    }

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, j, i);
                j++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        Code_0283 code_0283 = new Code_0283();
        int[] ints = {0, 1, 0, 3, 12};
//        int[] ints = {1};
        code_0283.moveZeroes(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
