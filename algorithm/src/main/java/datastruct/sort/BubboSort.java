package datastruct.sort;

/**
 * @author chenxinwei
 * @date 2021/3/10 8:48
 **/
public class BubboSort {


    public static void main(String[] args) {
        int[] array = SortUtil.generatorArray(10, 99);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);


        sort(array);
//        selectSort(array);
//        bubbleSort(array);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);
    }

    private static void sort(int[] a) {
        System.out.println("==================");
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (a[j] > a[i]) {
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
            SortUtil.Print(a);
        }
        System.out.println("==================");
    }
}
