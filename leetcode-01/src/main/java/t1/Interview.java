package t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interview {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        if (items == null || items.size() == 0) {
            return 0;
        }

        int count = 0;
        for (List<String> item : items) {
            switch (ruleKey) {
                case "type":
                    if (compare(item.get(0), ruleValue)) {
                        count++;
                    }
                    break;
                case "color":
                    if (compare(item.get(1), ruleValue)) {
                        count++;
                    }
                    break;
                case "name":
                    if (compare(item.get(2), ruleValue)) {
                        count++;
                    }
                    break;
                default:
                    break;
            }
        }
        return count;
    }

    private static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c_s1 = s1.toCharArray();
        char[] c_s2 = s2.toCharArray();
        for (int i = 0; i < c_s1.length; i++) {
            if (c_s1[i] != c_s2[i]) {
                return false;
            }
        }

        return true;
    }


    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, sum1 = 0, sum2 = 0;
        if (n > 6 * m || m > 6 * n) {//长度相差超过6倍，无解
            return -1;
        }
        for (int num1 : nums1) {
            sum1 += num1;
        }
        for (int num2 : nums2) {
            sum2 += num2;
        }

        if (sum1 == sum2) {
            return 0;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = 0;
        if (sum1 > sum2) {
            int i = n - 1, j = 0;//双指针
            while (sum1 > sum2) {
                if (j == m || nums1[i] - 1 > 6 - nums2[j]) {
                    sum1 -= nums1[i--] - 1;
                } else {
                    sum2 += 6 - nums2[j++];
                }
                ans++;
            }
        } else {
            int i = 0, j = m - 1;//双指针
            while (sum2 > sum1) {
                if (j == -1 || 6 - nums1[i] > nums2[j] - 1) {
                    sum1 += 6 - nums1[i++];
                } else {
                    sum2 -= nums2[j--] - 1;
                }

                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Interview interview = new Interview();
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("jjmj", "yyjj", "yyjj"));
        items.add(Arrays.asList("jjmj", "jjmj", "yyjj"));
        items.add(Arrays.asList("yyjj", "yyjj", "yyjj"));
        items.add(Arrays.asList("jjmj", "yyjj", "jjmj"));
        items.add(Arrays.asList("yyjj", "jjmj", "jjmj"));
        items.add(Arrays.asList("jjmj", "jjmj", "jjmj"));
        items.add(Arrays.asList("jjmj", "yyjj", "jjmj"));
        items.add(Arrays.asList("yyjj", "jjmj", "yyjj"));


        System.out.println(interview.countMatches(items, "color", "yyjj"));
    }
}
