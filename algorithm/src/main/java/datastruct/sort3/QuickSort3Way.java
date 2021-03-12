package datastruct.sort3;

import datastruct.sort.SortUtil;

/**
 * @author chenxinwei
 * @date 2021/2/25 18:00
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

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo, i = lo + 1, gt = hi;
        int tmp = a[lt];
        while (i <= gt) {
            if (a[i] == tmp) {
                i++;
            } else if (a[i] > tmp) {
                SortUtil.swap(a, i, gt--);
            } else {
                SortUtil.swap(a, i++, lt++);
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }


}
