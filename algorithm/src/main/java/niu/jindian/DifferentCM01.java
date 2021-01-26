package niu.jindian;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenxinwei
 * @date 2021/1/20 8:44
 **/
public class DifferentCM01 {
    public boolean checkDifferent(String iniString) {
        char[] chars = iniString.toCharArray();
        Set<Character> charSet = new HashSet<>(iniString.length() * 2);
        for (char aChar : chars) {
            charSet.add(aChar);
        }
        return charSet.size() == iniString.length();
    }
}
