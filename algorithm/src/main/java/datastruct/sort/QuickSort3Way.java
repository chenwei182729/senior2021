package datastruct.sort;

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

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        //a[lo..lt] < v = a[lt..gt] < a[gt+1..hi]
        int lt = lo, i = lo + 1, gt = hi;
        int tmp = a[lo];

        while (i <= gt) {
            if (tmp == a[i]) {
                i++;
            } else if (tmp > a[i]) {
                SortUtil.swap(a, lt++, i++);
            } else {
                SortUtil.swap(a, i, gt--);
            }
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

}
