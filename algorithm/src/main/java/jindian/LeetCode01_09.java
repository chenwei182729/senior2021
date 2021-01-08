package jindian;

/**
 * @author chenxinwei
 * @date 2020/12/30 17:48
 **/
public class LeetCode01_09 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if ((s1 == null && s2 != null) || (s1 != null && s2 == null)) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        String ss = s2 + s2;
        return ss.contains(s1);
    }

    public static void main(String[] args) {
        final LeetCode01_09 leetCode = new LeetCode01_09();
        String str1 = "aabcccccaa";
        String str2 = "aabcccccaa";
        System.out.println(leetCode.isFlipedString(str1, str2));
    }
}
