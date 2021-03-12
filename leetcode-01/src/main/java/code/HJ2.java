package code;

import java.util.Scanner;

/**
 * @author chenxinwei
 * @date 2021/2/23 14:41
 **/
public class HJ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String content = sc.nextLine().toUpperCase();
        Character ch = sc.nextLine().toUpperCase().charAt(0);

        int count = 0;
        for (char c : content.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        System.out.println(count);
    }
}
