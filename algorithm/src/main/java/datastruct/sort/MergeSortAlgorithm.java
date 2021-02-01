package datastruct.sort;

public class MergeSortAlgorithm {
    private static int[] aux;

    private static void merge(int[] arr, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (aux[j] < aux[i]) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }

    public static void merge(int[] arr) {
        aux = new int[arr.length];
        merge(arr, 0, arr.length - 1);
    }

    private static void merge(int[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        merge(arr, lo, mid);
        merge(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void mergeBU(int[] arr) {
        int N = arr.length;
        aux = new int[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(arr, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }


    public static void main(String[] args) {
        int[] array = SortUtil.generatorArray(1000, 999);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);
        mergeBU(array);
        System.out.println("isSort: " + SortUtil.isSort(array));
        SortUtil.Print(array);
    }
}
