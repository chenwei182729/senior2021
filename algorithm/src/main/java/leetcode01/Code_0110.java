package leetcode01;

/**
 * @author chenxinwei
 * @date 2021/2/19 16:50
 **/
public class Code_0110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);

        return Math.abs(height(root.left) - height(root.right)) <= 1 && leftBalanced && rightBalanced;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
