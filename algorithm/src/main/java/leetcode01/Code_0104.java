package leetcode01;

/**
 * @author chenxinwei
 * @date 2021/2/19 16:46
 **/
public class Code_0104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        return left > right ? left : right;
    }


}
