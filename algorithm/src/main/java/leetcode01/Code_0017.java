package leetcode01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_0017 {
    private static Map<Character, String> PHONE_MAP = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        _backtrack(combinations, digits, 0, new StringBuffer());
        return combinations;
    }

    private void _backtrack(List<String> combinations, String digits, int index, StringBuffer sb) {
        if (index == digits.length()) {
            combinations.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = PHONE_MAP.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                sb.append(letters.charAt(i));
                _backtrack(combinations, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
