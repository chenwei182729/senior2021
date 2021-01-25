package datastruct.sort;

import java.util.Random;

public class SortUtil {
    public static int[] generatorArray(int n, int bound) {
        if (n < 0) {
            System.out.println("n must large than 0");
            return new int[]{};
        }
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    public static void Print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static boolean isSort(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }
        int len = array.length - 1;
        for (int i = 0; i < len; i++) {
            if (array[i + 1] < array[i]) {
//                System.out.println("=============");
//                System.out.println(array[i+1]+" less than "+array[i]);
//                System.out.println("=============");
                return false;
            }
        }
        return true;
    }
}
