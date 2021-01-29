package datastruct.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = SortUtil.generatorArray(100, 99);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);

        sort(array);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int tmp = a[lo];
        while (true) {
            while (a[++i] < tmp) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > tmp) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            SortUtil.swap(a, i, j);
        }
        SortUtil.swap(a, lo, j);
        return j;
    }

}
