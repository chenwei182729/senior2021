package leetcode01;

import java.util.ArrayList;
import java.util.List;

public class Code_0094 {
    private List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        _traval(root);
        return result;
    }

    private void _traval(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            _traval(root.left);
        }

        result.add(root.val);

        if (root.right != null) {
            _traval(root.right);
        }
    }

    public static void main(String[] args) {

    }
}
