package leetcode01;

public class Code_0011 {
    public int maxArea2(int[] height) {
        int max = 0;
        int lo = 0, hi = height.length - 1;
        while (lo < hi) {
            int area = Math.min(height[lo], height[hi]) * (hi - lo);
            max = Math.max(max, area);

            if (height[lo] < height[hi]) {
                ++lo;
            } else {
                --hi;
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[j], height[i]) * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
