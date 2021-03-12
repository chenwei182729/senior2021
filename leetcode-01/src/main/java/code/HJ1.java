package code;

import java.util.Scanner;

/**
 * @author chenxinwei
 * @date 2021/2/23 14:38
 **/
public class HJ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = null;
        while (sc.hasNext()) {
            line = sc.next();
        }
        System.out.println(line.length());
    }
}
