package code;

import java.util.Scanner;

/**
 * @author chenxinwei
 * @date 2021/2/23 14:47
 **/
public class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[1001];
        int N = 0;

        while (sc.hasNext()) {
            N = sc.nextInt();
            for (int i = 0; i < 1001; i++) {
                array[i] = 0;
            }
            for (int i = 0; i < N; i++) {
                array[sc.nextInt()]++;
            }
            for (int i = 0; i < 1001; i++) {
                if (array[i] > 0) {
                    System.out.println(i);
                }
            }
        }
    }
}
