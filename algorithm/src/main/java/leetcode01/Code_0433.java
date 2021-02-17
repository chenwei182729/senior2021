package leetcode01;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class Code_0433 {

    private int minStepCount;
    public int minMutation(String start, String end, String[] bank) {
        minStepCount = Integer.MAX_VALUE;
        dfs(new HashSet<>(), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }

    private void dfs(HashSet<String> step, int stepCount, String current, String end, String[] bank) {
        if (current.equals(end)) {
            minStepCount = Math.min(stepCount, minStepCount);
        }

        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (current.charAt(i) != str.charAt(i)) {
                    if (++diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1 && !step.contains(str)) {
                step.add(str);
                dfs(step, stepCount + 1, str, end, bank);
                step.remove(str);
            }
        }
    }

}
