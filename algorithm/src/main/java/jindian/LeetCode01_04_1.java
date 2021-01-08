package jindian;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxinwei
 * @date 2020/12/30 17:48
 **/
public class LeetCode01_04_1 {
    public boolean canPermutePalindrome(String s) {
        final char[] chars = s.toCharArray();
        Map<Character, Integer> charCountMap = new HashMap<>(256);
        for (int i = 0; i < chars.length; i++) {
            charCountMap.put(chars[i], charCountMap.getOrDefault(chars[i], 0) + 1);
        }

        return charCountMap.values().stream().filter(v -> v % 2 == 1).count() <= 1L;
    }

    public static void main(String[] args) {
        final LeetCode01_04_1 leetCode01_04 = new LeetCode01_04_1();
        final String s = "tactcoa";
        boolean result = leetCode01_04.canPermutePalindrome(s);
        System.out.println(result);
    }
}
