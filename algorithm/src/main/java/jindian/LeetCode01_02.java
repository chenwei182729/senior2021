package jindian;

/**
 * @author chenxinwei
 * @date 2020/12/30 17:48
 **/
public class LeetCode01_02 {
    /**
     * 判定是否互为字符重排
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if ((s1 == null && s2 != null) || (s1 != null && s2 == null) || (s1.length() != s2.length())) {
            return false;
        }

        int[] charCount = new int[256];
        for (char c : s1.toCharArray()) {
            charCount[c]++;
        }
        for (char c : s2.toCharArray()) {
            charCount[c]--;
        }
        for (int i : charCount) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode01_02 leetCode01_01 = new LeetCode01_02();
        System.out.println(leetCode01_01.CheckPermutation("abc", "bad"));

    }
}
