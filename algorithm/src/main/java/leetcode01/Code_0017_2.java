package leetcode01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_0017_2 {
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
    private List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() > 0) {
            _backtrack(digits, 0, new StringBuilder());
        }
        return result;
    }

    private void _backtrack(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char tag = digits.charAt(index);
        String letters = PHONE_MAP.get(tag);
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            _backtrack(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Code_0017_2 code_0017_2 = new Code_0017_2();
        System.out.println(code_0017_2.letterCombinations("23"));
    }
}
