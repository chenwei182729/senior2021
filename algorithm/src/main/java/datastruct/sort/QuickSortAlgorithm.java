package datastruct.sort;

public class QuickSortAlgorithm {
    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int tmp = a[lo];
        while (true) {
            while (a[++i] < tmp) if (i == hi) break;
            while (tmp < a[--j]) if (j == lo) break;
            if (i >= j) break;
            SortUtil.swap(a, i, j);
        }
        SortUtil.swap(a, lo, j);
        return j;
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
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
