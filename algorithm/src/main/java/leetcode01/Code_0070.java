package leetcode01;

public class Code_0070 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 2; i < n; i++) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }

        return f3;
    }
}
