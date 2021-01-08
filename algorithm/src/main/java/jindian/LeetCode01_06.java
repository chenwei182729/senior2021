package jindian;

import java.util.Arrays;

/**
 * @author chenxinwei
 * @date 2020/12/30 17:48
 **/
public class LeetCode01_06 {
    public String compressString(String S) {
        if (S == null || S.length() < 3) {
            return S;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = S.toCharArray();
        char preChat = charArray[0];
        int count = 1;

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == preChat) {
                count = count + 1;
            } else {
                stringBuilder.append(preChat).append(count);
                count = 1;
                preChat = charArray[i];
            }
        }
        stringBuilder.append(preChat).append(count);
        String result = stringBuilder.toString();
        if (result.length() < S.length()) {
            return result;
        } else {
            return S;
        }
    }

    public static void main(String[] args) {
        final LeetCode01_06 leetCode = new LeetCode01_06();
        String str = "aabcccccaa";
        System.out.println(leetCode.compressString(str));
    }
}
