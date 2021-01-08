package com.cninfo.forwhile;

/**
 * @author chenxinwei
 * @date 2020/12/30 16:31
 **/
public class WhileDemo {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            if (i >= 1000) {
                break;
            }
            System.out.println(i);
            i++;
        }
    }
}
