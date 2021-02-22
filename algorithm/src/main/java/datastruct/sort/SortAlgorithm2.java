package datastruct.sort;

public class SortAlgorithm2 {
    public static void main(String[] args) {
        int[] array = SortUtil.generatorArray(100, 99);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);

//        insertSort(array);
        selectSort(array);
//        bubbleSort(array);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);
    }

    private static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minPos]) {
                    minPos = j;
                }
            }
            SortUtil.swap(nums,i,minPos);
        }
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    SortUtil.swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[j + 1]) {
                    SortUtil.swap(nums, j, j + 1);
                }
            }
        }
    }
}
