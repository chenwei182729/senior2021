package leetcode01;

import java.util.*;

/**
 * @author chenxinwei
 * @date 2021/2/19 17:00
 **/
public class Code_0199 {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightMostValueMap = new HashMap<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        int max_depth = -1;
        depthQueue.add(0);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
                max_depth = Math.max(max_depth, depth);

                rightMostValueMap.put(depth, node.val);

                queue.add(node.left);
                queue.add(node.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }
        List<Integer> rightView = new ArrayList<>();

        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightMostValueMap.get(depth));
        }
        return rightView;
    }


}
