package datastruct.sort2;

import datastruct.sort.SortUtil;

/**
 * @author chenxinwei
 * @date 2021/2/19 15:23
 **/
public class QuickSort3Way {
    public static void main(String[] args) {
        int[] array = SortUtil.generatorArray(100, 99);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);

        sort(array);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);
    }

    private static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        //<= [lt gt] <=

        int lt = lo, i = lo + 1, gt = hi;
        int tmp = a[lo];

        while (i <= gt) {
            if (a[i] == tmp) {
                i++;
            } else if (a[i] < tmp) {
                SortUtil.swap(a, lt++, i++);
            } else {
                SortUtil.swap(a, i, gt--);
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
