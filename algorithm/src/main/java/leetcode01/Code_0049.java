package leetcode01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Code_0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String tag = tag(str);
            List<String> list = map.getOrDefault(tag, new ArrayList<>());
            list.add(str);
            map.put(tag, list);
        }

        List<List<String>> collect = map.values().stream().collect(Collectors.toList());
        return collect;
    }

    public String tag(String s) {
        int[] count = new int[26];
        for (char aChar : s.toCharArray()) {
            count[aChar - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                sb.append('a' + i).append(count[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Code_0049 code_0049 = new Code_0049();
        String[] params = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = code_0049.groupAnagrams(params);
        lists.stream().forEach(System.out::println);
    }
}

//class Solution {
//    private static final int[] MARK = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
//            71, 73, 79, 83, 89, 97, 101};
//
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<Long, List<String>> result = new HashMap<>(strs.length);
//        List<String> list;
//        for (String s : strs) {
//            long index = calculate(s);
//            list = result.getOrDefault(index, new ArrayList<>());
//            list.add(s);
//            result.put(index, list);
//        }
//        return new ArrayList<>(result.values());
//    }
//
//    private long calculate(String s) {
//        long temp = 1;
//        for (char c : s.toCharArray()) {
//            temp *= MARK[c - 'a'];
//        }
//        return temp;
//    }
//}
