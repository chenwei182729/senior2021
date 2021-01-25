package datastruct.sort;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] array = SortUtil.generatorArray(100, 99);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);


//        insertSort(array);
//        selectSort(array);
        bubbleSort(array);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);
    }

    public static int[] insertSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j + 1] < array[j]) {
                    SortUtil.swap(array, j + 1, j);
                }
            }
        }
        return array;
    }

    public static int[] selectSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int minIdx = i;
            int minVal = array[i];
            for (int j = i + 1; j < len; j++) {
                if (array[j] < minVal) {
                    minIdx = j;
                    minVal = array[j];
                }
            }
            SortUtil.swap(array, i, minIdx);
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    SortUtil.swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

}
