package datastruct.sort;

public class ShellSortAlgorithm {

    public static void sort(int[] arr) {
        int N = arr.length;
        int h = 1;
        while (h <= N / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && (arr[j] < arr[j - h]); j = j - h) {
                    SortUtil.swap(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generatorArray(1000, 999);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);
        sort(array);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);
    }
}
